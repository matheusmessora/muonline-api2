package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pandox.china.controller.BaseController;
import pandox.china.dto.ServerDTO;
import pandox.china.service.ServerService;
import pandox.china.service.cache.CacheService;

@Controller
@RequestMapping
public class ServerAPI extends BaseController {

    private static Logger log = Logger.getLogger(ServerAPI.class);

    @Autowired
    private ServerService service;


    @Autowired
    private CacheService cache;

    @RequestMapping(value = "/server", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ServerDTO findAll() {

        ServerDTO serverDTO = cache.getServerDTO();
        if (serverDTO == null) {
            serverDTO = service.get();
            cache.putServerDTO(serverDTO);

        }

        return serverDTO;
    }


}
