package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pandox.china.controller.BaseController;
import pandox.china.dto.CheckoutDTO;
import pandox.china.dto.ItemDTO;
import pandox.china.model.custom.Profile;
import pandox.china.service.ItemService;
import pandox.china.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class ItemAPI extends BaseController {

    private static Logger log = Logger.getLogger(ItemAPI.class);

    @Autowired
    private ItemService service;

    @Autowired
    private ProfileService profileService;


    @Autowired(required = false)
    private HttpServletRequest request;

    @RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ItemDTO> findAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ItemDTO find(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/checkout", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void buy(@RequestBody CheckoutDTO itemDTO) {
        Profile profile = profileService.getFromRequest(request);
        log.info("compraITEM. profile=" + profile.getId() + ", login=" + profile.getMembInfo().getMembId() + ", item=" + itemDTO.getItem());


        service.buy(profile, itemDTO.getItem());
    }
}
