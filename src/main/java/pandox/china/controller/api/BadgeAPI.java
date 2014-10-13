package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pandox.china.controller.BaseController;
import pandox.china.dto.BadgeDTO;
import pandox.china.service.BadgeService;

import java.util.List;

@Controller
@RequestMapping
public class BadgeAPI extends BaseController {

    private static Logger log = Logger.getLogger(BadgeAPI.class);

    @Autowired
    private BadgeService service;

    @RequestMapping(value = "/badge", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<BadgeDTO> findAll() {
        return service.getAll();
    }

}
