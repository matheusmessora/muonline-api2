package pandox.china.service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.AccountDTO;
import pandox.china.dto.ErroDTO;
import pandox.china.dto.TokenDTO;
import pandox.china.exception.BadRequestException;
import pandox.china.model.MembInfo;
import pandox.china.repo.AccountRepository;
import pandox.china.service.auth.AuthenticationService;
import pandox.china.service.auth.AuthenticationServiceImpl;
import pandox.china.service.cache.CacheService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private static Logger log = Logger.getLogger(AccountServiceImpl.class);


    @Autowired
    private AccountRepository membInfoRepo;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CacheService cache;


    @Override
    public List<AccountDTO> findAll() {
        Iterable<MembInfo> entities = membInfoRepo.findAll();


        List<AccountDTO> resultList = new ArrayList();
        for (MembInfo entity : entities) {
            resultList.add(new AccountDTO(entity));
        }

        return resultList;
    }

    @Override
    public AccountDTO save(AccountDTO dto) {
        MembInfo membInfo = membInfoRepo.findByMembId(dto.getLogin());
        if (membInfo != null) {
            throw new BadRequestException(new ErroDTO("login", "Login já existe."));
        }


        MembInfo entity = new MembInfo(dto);
        entity.setBlocCode("0");
        entity.setCtl1Code("0");
        entity.setMailChek("0");
        entity.setVipFree((byte) 0);

        entity.setSnoNumb("123456789012345678");
        entity.setScfExtWarehouse((byte) 0);
        entity.setScfIsVip((short) 0);
        entity.setScfLuckyCoins(0);
        entity.setScfVipDays(0);
        entity.setScfVipMoney(0);
        entity.setScfWareVipCount(0);
        entity.setScfExtWarehouse((byte) 0);
        entity.setwCoin(0);
        entity.setwCoinP(0);
        entity.setGoblinCoin(0);
        entity.setGoldChannelTime(0);

        entity = membInfoRepo.save(entity);
        log.info("login=" + dto.getLogin() + ". Conta criada com sucesso");

        //Send Email
        dto = new AccountDTO(entity);
        String token = getToken(dto);
        emailService.sendCreationEmail(dto, token);

        return dto;
    }

    private String getToken(AccountDTO accountDTO) {
        String token = cache.getCreationToken(accountDTO.getId());
        if (StringUtils.isBlank(token)) {
            token = AuthenticationServiceImpl.generateToken(accountDTO.getLogin(), accountDTO.getId());
            cache.putCreationToken(accountDTO.getId(), token);
        }

        return token;
    }

    @Override
    public AccountDTO findByCookie(HttpServletRequest request) {
        TokenDTO tokenDTO = authService.userLogged(request);
        if (tokenDTO != null) {
            MembInfo entity = membInfoRepo.findOne(tokenDTO.getId());
            if (entity != null) {
                return new AccountDTO(entity);
            }
        }
        return null;
    }

    @Override
    public void setConfirmedMail(Integer membGuid) {
        MembInfo one = membInfoRepo.findOne(membGuid);
        if (one != null) {
            one.setMailChek("1");
            membInfoRepo.save(one);
            log.info("Email.confirmado membGuid=" + one.getMembId());
        } else {
            throw new BadRequestException(new ErroDTO("token", "Token inválido"));
        }
    }
}
