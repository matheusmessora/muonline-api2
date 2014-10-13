package pandox.china.service.auth;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;
import pandox.china.dto.AccountDTO;
import pandox.china.dto.TokenDTO;
import pandox.china.exception.UnauthorizedException;
import pandox.china.model.MembInfo;
import pandox.china.repo.AccountRepository;
import pandox.china.repo.ProfileRepository;
import pandox.china.service.cache.CacheService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    public static final String COOKIE_TOKEN = "X-WOMU-Auth";
    private static final byte[] salt = KeyGenerators.shared(16).generateKey();
    private static Logger log = Logger.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;


    @Autowired
    private CacheService cache;

    public static String generateToken(String login, Integer id) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(buildHash(login, id).getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("Falha ao realizar criptografia. login=" + login + ",id=" + id, e);
        }
        log.debug("GenerateHash. login=" + login + ",id" + id + ",hash=" + generatedPassword + ",size=" + generatedPassword.getBytes().length);
        return generatedPassword;
    }

    private static String buildHash(String login, Integer id) {
        return login + "|" + id + new Date();

    }

    @Override
    public TokenDTO login(AccountDTO dto, HttpServletResponse response) {
        String login = dto.getLogin();
        String password = dto.getPassword();

        MembInfo membInfo = repository.findByMembIdAndMembPwd(login, password);
        if (membInfo != null) {
            String token = generateToken(login, membInfo.getMembGuid());

            cache.putAuthentication(token, membInfo.getMembGuid());

            return new TokenDTO(token);
        }

        throw new BadCredentialsException("Login e senha inválido");
    }

    @Override
    public TokenDTO userLogged(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(COOKIE_TOKEN)) {
                    Integer membGuid = cache.getAuthentication(cookie.getValue());
                    if (membGuid != null) {
                        return new TokenDTO(cookie.getValue(), membGuid);
                    }
                }
            }
        }


        throw new UnauthorizedException();
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(new Cookie(COOKIE_TOKEN, ""));
    }

}
