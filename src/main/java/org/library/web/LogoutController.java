package org.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LogoutController {

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String doLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "login";
    }
}
