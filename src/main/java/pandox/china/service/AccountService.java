package pandox.china.service;

import pandox.china.dto.AccountDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface AccountService {

    List<AccountDTO> findAll();

    AccountDTO save(AccountDTO dto);

    AccountDTO findByCookie(HttpServletRequest request);

    void setConfirmedMail(Integer membGuid);
}
