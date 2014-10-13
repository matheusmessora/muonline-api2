package pandox.china.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pandox.china.controller.BaseController;
import pandox.china.dto.AccountDTO;
import pandox.china.dto.ErroDTO;
import pandox.china.dto.TokenDTO;
import pandox.china.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginAPI extends BaseController {

    @Autowired
    private AuthenticationService service;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public TokenDTO login(@RequestBody AccountDTO dto, HttpServletRequest request, HttpServletResponse response) {
        return service.login(dto, response);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        service.logout(request, response);
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public TokenDTO get(HttpServletRequest request, HttpServletResponse response) {
        return service.userLogged(request);
    }


    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ErroDTO> badCredentialsExceptionHandler(BadCredentialsException ex, HttpServletResponse response) {
        List<ErroDTO> list = new ArrayList<>();
        list.add(new ErroDTO("login", "Login ou senha inválidos."));

        return list;
    }

}
