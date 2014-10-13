package pandox.china.controller.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pandox.china.controller.BaseController;
import pandox.china.dto.ProfileDTO;
import pandox.china.dto.TokenDTO;
import pandox.china.service.ProfileService;
import pandox.china.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class ProfileAPI extends BaseController {

    private static Logger log = Logger.getLogger(ProfileAPI.class);

    @Autowired
    private AuthenticationService auth;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ProfileService service;

    @RequestMapping(value = "/profile", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ProfileDTO findLogged() {
        TokenDTO token = auth.userLogged(request);


        return service.getFromMembInfo(token.getId());
    }

    @RequestMapping(value = "/profile/{login}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ProfileDTO findLogged(@PathVariable("login") String login) {

        ProfileDTO profileDTO = service.getFromLogin(login);

        return profileDTO;
    }

}
