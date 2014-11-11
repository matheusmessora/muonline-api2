package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pandox.china.controller.BaseController;
import pandox.china.dto.AccountDTO;
import pandox.china.service.AccountService;
import pandox.china.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class AccountAPI extends BaseController {

    private static Logger log = Logger.getLogger(AccountAPI.class);

    @Autowired
    private AccountService service;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<AccountDTO> findAll(HttpServletRequest request) {
        if(authenticationService.isADMIN(request)) {

            List<AccountDTO> accountDTOs = service.findAll();
            for (AccountDTO accountDTO : accountDTOs) {
                accountDTO.setPassword(null);
            }
            return accountDTOs;

        }

        return null;

    }


    @RequestMapping(value = "/me", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AccountDTO whoAmI(HttpServletRequest request) {
        AccountDTO accountDTO = service.findByCookie(request);
        if (accountDTO != null) {
            accountDTO.setPassword(null);
        }
        return accountDTO;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AccountDTO create(@Valid @RequestBody AccountDTO dto) {
        return service.save(dto);
    }


}

