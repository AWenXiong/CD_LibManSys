package org.library.web;

import org.library.entity.book;
import org.library.entity.user;
import org.library.service.userservice;
import org.library.service.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashSet;

@Controller
@RequestMapping(value = "/jsp")
public class SearchBookController {

    @Autowired
    userservice userservice;
    @Autowired
    adminservice adminservice;

    //管理员搜索图书
    @RequestMapping(value = "/admin/doSearchBook", method = RequestMethod.GET)
    public String adminDoSearchBook(String condition, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        HashSet<book> bookList = adminservice.queryBook(condition);
        model.addAttribute("bookList", bookList);
        return "admin/searchBookList";
    }

    //用户搜索图书
    @RequestMapping(value = "/user/doSearchBook", method = RequestMethod.GET)
    public String userDoSearchBook(String condition, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        HashSet<book> bookList = userservice.querybook(condition);
        model.addAttribute("bookList", bookList);
        return "user/searchBookList";
    }
}
