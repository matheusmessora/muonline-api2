package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pandox.china.controller.BaseController;
import pandox.china.dto.ErroDTO;
import pandox.china.exception.BadRequestException;
import pandox.china.service.AccountService;
import pandox.china.service.cache.CacheService;

@Controller
@RequestMapping
public class EmailAPI extends BaseController {

    private static Logger log = Logger.getLogger(EmailAPI.class);

    @Autowired
    private CacheService cacheService;

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/email/confirmation", method = RequestMethod.PUT, produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public void create(@RequestParam String token) {
        Integer membGuid = cacheService.getMembGuidFromToken(token);
        log.info("Email.validacao membGuid=" + membGuid);
        if (membGuid != null) {
            accountService.setConfirmedMail(membGuid);
        } else {
            throw new BadRequestException(new ErroDTO("token", "Token inválido"));
        }
    }


}
