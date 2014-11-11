package pandox.china.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pandox.china.dto.CreditDTO;
import pandox.china.model.custom.Profile;
import pandox.china.service.CreditService;
import pandox.china.service.ProfileService;
import pandox.china.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class CreditAPI {

    @Autowired
    private CreditService creditService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthenticationService authenticationService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/credit/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CreditDTO buy(@PathVariable("id") Integer id) {
        Profile profile = profileService.getFromRequest(request);

        return creditService.persist(profile, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/perfil/{id}/credit/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CreditDTO putCredit(@PathVariable("id") Integer id) {
            Profile profile = profileService.getFromRequest(request);
            return creditService.persist(profile, id);
    }
}
