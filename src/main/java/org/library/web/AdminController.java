package org.library.web;

import org.library.dto.WebDropBook;
import org.library.dto.WebReserveBook;
import org.library.entity.book;
import org.library.entity.dropBook;
import org.library.entity.reserveBook;
import org.library.entity.user;
import org.library.service.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

@Controller
@RequestMapping(value = "/jsp/admin")
public class AdminController {

    @Autowired
    adminservice adminservice;

    //需要反馈
    //新增图书
    @RequestMapping(value = "/doAddBook", method = RequestMethod.POST)
    public String doAddBook(String bookName, String bookWriter, String bookPress,
                            String bookType, int totalBook, Model model, HttpSession httpSession) {
        httpSession.removeAttribute("successfullyAddBook");
        if (adminservice.addBook(bookName, bookWriter, bookPress, bookType, totalBook)) {
            httpSession.setAttribute("successfullyAddBook", true);
        } else {

        }
        return "admin/addBook";
    }

    //需要反馈
    //新增用户
    @RequestMapping(value = "/doAddUser", method = RequestMethod.POST)
    public String doAddUser(String userName, String password, int type, Model model, HttpSession httpSession) {
        String haha = "abc" + password;
        String md5 = DigestUtils.md5DigestAsHex(haha.getBytes());
        httpSession.removeAttribute("successfullyAddUser");
        if (adminservice.addUser(userName, md5, type)) {
            httpSession.setAttribute("successfullyAddUser", true);
        } else {

        }
        return "admin/addUser";
    }

    //获取图书详情
    //若bookID == null, 重定向到搜索页面
    @RequestMapping(value = "/{bookId}/bookDetail", method = RequestMethod.GET)
    public String getBookDetail(@PathVariable("bookId") String bookId, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        if (bookId == null) {
            return "searchBook";
        }
        book book = adminservice.queryId(bookId);
        model.addAttribute("book", book);
        httpSession.setAttribute("specialBookId", book.getBookId());
        httpSession.setAttribute("specialBookName", book.getBookName());
        httpSession.setAttribute("specialBookTotal", book.getBookTotal());
        httpSession.setAttribute("specialBookStock", book.getBookStock());
        httpSession.setAttribute("specialBookWriter", book.getBookWriter());
        httpSession.setAttribute("specialBookPress", book.getBookPress());
        httpSession.setAttribute("specialBookType", book.getBookType());
        return "admin/bookDetail";
    }

    //获取用户详情
    //若userID == null, 重定向到搜索页面
    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    public String getUserDetail(String userID, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        if (userID == null) {
            return "admin/searchUser";
        }
        user user = adminservice.getUser(userID);
        if (user == null) {
            return "admin/searchUser";
        }
        model.addAttribute("user", user);
        httpSession.setAttribute("specialUserId", user.getUserId());
        httpSession.setAttribute("specialUserName", user.getUserName());
        httpSession.setAttribute("specialUserType", user.getUserType());
        return "admin/userDetail";
    }

    //获取还书请求列表
    @RequestMapping(value = "/returnRequest", method = RequestMethod.GET)
    public String getReturnRequest(Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        ArrayList<dropBook> allDropBooks = adminservice.queryDrop();
        ArrayList<WebDropBook> returnList = new ArrayList<WebDropBook>();
        for (dropBook dropBook : allDropBooks) {
            if (dropBook.getState() == 1) {
                user user = adminservice.getUser(dropBook.getReaderId());
                book book = adminservice.queryId(dropBook.getBookId());
                String userName = user.getUserName();
                String createTime = dropBook.getCreateTime().toString();
                createTime = createTime.substring(0, createTime.length() - 2);

                WebDropBook webDropBook = new WebDropBook();
                webDropBook.setUserId(dropBook.getReaderId());
                webDropBook.setBookId(dropBook.getBookId());
                webDropBook.setUserName(userName);
                webDropBook.setBookName(book.getBookName());
                webDropBook.setCreateTime(createTime);
                returnList.add(webDropBook);

                System.out.println(webDropBook);
            }
        }
        model.addAttribute("returnList", returnList);
        return "admin/returnRequest";
    }

    //同意还书请求
    @RequestMapping(value = "/{userId}/{bookId}/{createTime}/agreeReturnRequest", method = RequestMethod.GET)
    public String agreeReturnRequest(@PathVariable("userId") String userId, @PathVariable("bookId") String bookId,
                                     @PathVariable("createTime") String createTime, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        dropBook dropBook = new dropBook(userId, bookId, Timestamp.valueOf(createTime), 0);
        httpSession.removeAttribute("successfullyAgreeReturn");
        if (adminservice.agreeDrop(dropBook)) {
            httpSession.setAttribute("successfullyAgreeReturn", true);
        } else {

        }
        return getReturnRequest(model, httpSession);
    }

    //获取预定（借书）请求列表
    @RequestMapping(value = "/reserveRequest", method = RequestMethod.GET)
    public String getReserveRequest(Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        ArrayList<reserveBook> allReserveBooks = adminservice.queryReserve();
        ArrayList<WebReserveBook> reserveList = new ArrayList<WebReserveBook>();
        for (reserveBook reserveBook : allReserveBooks) {
            if (reserveBook.getState() == 0) {
                user user = adminservice.getUser(reserveBook.getReaderId());
                book book = adminservice.queryId(reserveBook.getBookId());
                String createTime = reserveBook.getCreateTime().toString();
                createTime = createTime.substring(0, createTime.length() - 2);

                WebReserveBook webReserveBook = new WebReserveBook();
                webReserveBook.setUserId(user.getUserId());
                webReserveBook.setUserName(user.getUserName());
                webReserveBook.setBookId(book.getBookId());
                webReserveBook.setBookName(book.getBookName());
                webReserveBook.setBookWriter(book.getBookWriter());
                webReserveBook.setCreateTime(createTime);
                reserveList.add(webReserveBook);
            }
        }
        model.addAttribute("reserveList", reserveList);
        return "admin/reserveRequest";
    }

    //同意预定（借书）请求
    @RequestMapping(value = "/{userId}/{bookId}/{createTime}/agreeLendRequest", method = RequestMethod.GET)
    public String agreeLendRequest(@PathVariable("userId") String userId, @PathVariable("bookId") String bookId,
                                   @PathVariable("createTime") String createTime, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        reserveBook reserveBook = new reserveBook(userId, bookId, Timestamp.valueOf(createTime), 0);
        httpSession.removeAttribute("successfullyAgreeReserve");
        if (adminservice.agreeLend(reserveBook)) {
            httpSession.setAttribute("successfullyAgreeReserve", true);
        } else {

        }
        return getReserveRequest(model, httpSession);
    }

    //获取图书搜索结果列表
    @RequestMapping(value = "/searchBookList", method = RequestMethod.GET)
    public String getSearchBookList(String condition, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        HashSet<book> bookSet = adminservice.queryBook(condition);
        model.addAttribute("bookList", bookSet);
        return "searchBookList";
    }

    //需要反馈
    //更新书籍
    @RequestMapping(value = "/doUpdateBook", method = RequestMethod.POST)
    public String doUpdateBook(String bookId, String bookName, String bookWriter, String bookPress,
                               int stockBook, int totalBook, String bookType, Model model, HttpSession httpSession) {
        book book = new book(bookId, bookName, bookWriter, bookPress, bookType, stockBook, totalBook);
        httpSession.removeAttribute("successfullyUpdateBook");
        if (adminservice.updateBook(book)) {
            httpSession.setAttribute("successfullyUpdateBook", true);
        } else {

        }
        return "admin/searchBook";
    }

    //需要反馈
    //更新用户
    @RequestMapping(value = "/doUpdateUser", method = RequestMethod.POST)
    public String doUpdateUser(String userId, String userName, String password, int userType, Model model, HttpSession httpSession) {
        String haha = "abc" + password;
        String md5 = DigestUtils.md5DigestAsHex(haha.getBytes());
        user user = new user();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPassWord(md5);
        user.setUserType(userType);
        httpSession.removeAttribute("successfullyUpdateUser");
        if (adminservice.updateUserInformation(user)) {
            httpSession.setAttribute("successfullyUpdateUser", true);
        } else {

        }
        return "admin/searchUser";
    }

    //需要反馈;method如何解决
    //删除用户
    @RequestMapping(value = "/{userID}/deleteUser", method = RequestMethod.GET)
    public String doDeleteUser(@PathVariable("userID") String userID, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        httpSession.removeAttribute("successfullyDeleteUser");
        if (adminservice.deleteUser(userID)) {
            httpSession.setAttribute("successfullyDeleteUser", true);
        } else {

        }
        return "admin/searchUser";
    }

    //需要反馈;method如何解决
    //删除图书
    @RequestMapping(value = "/{bookId}/doDeleteBook", method = RequestMethod.GET)
    public String doDeleteBook(@PathVariable("bookId") String bookId, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 0) return "/user/searchBook";
        httpSession.removeAttribute("successfullyDeleteBook");
        if (adminservice.deleteBook(bookId)) {
            httpSession.setAttribute("successfullyDeleteBook", true);
        } else {

        }
        return "admin/searchBook";
    }
}
