package pandox.china.service.auth;

import pandox.china.dto.AccountDTO;
import pandox.china.dto.TokenDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService {

    boolean isADMIN(HttpServletRequest request);

    TokenDTO login(AccountDTO dto, HttpServletResponse response);

    TokenDTO userLogged(HttpServletRequest request);

    void logout(HttpServletRequest request, HttpServletResponse response);
}
