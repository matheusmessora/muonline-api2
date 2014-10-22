package pandox.china.controller.api;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pandox.china.controller.BaseController;
import pandox.china.dto.AccountDTO;
import pandox.china.dto.HeroDTO;
import pandox.china.service.AccountService;
import pandox.china.service.HeroServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class HeroAPI extends BaseController {

    private static Logger log = Logger.getLogger(HeroAPI.class);

    @Autowired
    private AccountService service;

    @Autowired
    private HeroServiceImpl heroService;

    @Autowired(required = false)
    private HttpServletRequest request;

    @RequestMapping(value = "/me/hero", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HeroDTO> findAllByLoggedUser() {
        AccountDTO accountDTO = service.findByCookie(request);

        return heroService.getAllByLogin(accountDTO.getLogin());
    }

    @RequestMapping(value = "/hero", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HeroDTO> findAll(@RequestParam(value = "type", required = false) String heroType,
                                 @RequestParam(value = "size", required = false) Integer size,
                                 @RequestParam(value = "order", required = false) String order) {

        if(StringUtils.isBlank(order)) {
            order = "reset";
        }

        if(size == null || size == 0) {
            size = 30;
        }


        return heroService.getAll(heroType, size, order);
    }
}
