package org.library.web;

import org.library.entity.user;
import org.library.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class LoginController {

    @Autowired
    private loginservice loginservice;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(String userName, String password, Model model, HttpSession httpSession) {
        Enumeration em = httpSession.getAttributeNames();
        while (em.hasMoreElements()) {
            httpSession.removeAttribute(em.nextElement().toString());
        }
        String haha = "abc" + password;
        String md5 = DigestUtils.md5DigestAsHex(haha.getBytes());
        user user = loginservice.login(userName, md5);
        if (user == null) {
            httpSession.setAttribute("loginResult", false);
            return "login";
        } else {
            model.addAttribute("result", true);
            String type = "";
            if (user.getUserType() == 0) type = "user";
            else type = "admin";
            httpSession.setAttribute("userId", user.getUserId());
            httpSession.setAttribute("userName", user.getUserName());
            httpSession.setAttribute("userType", user.getUserType());
            return type + "/searchBook";
        }
    }
}
