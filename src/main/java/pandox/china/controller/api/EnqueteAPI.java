package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pandox.china.controller.BaseController;
import pandox.china.dto.EnqueteDTO;
import pandox.china.exception.NoContentException;
import pandox.china.model.custom.Profile;
import pandox.china.service.EnqueteService;
import pandox.china.service.ProfileService;
import pandox.china.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class EnqueteAPI extends BaseController {

    private static Logger log = Logger.getLogger(EnqueteAPI.class);

    @Autowired
    private EnqueteService service;

    @Autowired
    private AuthenticationService auth;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/enquete", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<EnqueteDTO> findAll(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "answerable", required = false, defaultValue = "false") boolean answerable) {
        Profile profile = profileService.getFromRequest(request);

        List<EnqueteDTO> all = service.getAll(status, profile, answerable);
        if (all.isEmpty()) {
            throw new NoContentException();
        }
        return all;
    }

    @RequestMapping(value = "/enquete/{id}/answer/{answerId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void findAll(@PathVariable(value = "id") Integer id, @PathVariable(value = "answerId") Integer answerId) {
        Profile profile = profileService.getFromRequest(request);

        service.doAnswer(id, answerId, profile.getId());
    }

}
