package org.library.web;

import org.library.dto.WebBorrowBook;
import org.library.dto.WebReserveBook;
import org.library.entity.book;
import org.library.entity.borrowBook;
import org.library.entity.reserveBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.library.service.userservice;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/jsp/user")
public class UserController {

    @Autowired
    userservice userservice;

    //获取图书详情
    @RequestMapping(value = "/{bookID}/bookDetail", method = RequestMethod.GET)
    public String getBookDetail(@PathVariable("bookID") String bookID, Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        book book = userservice.queryId(bookID);
        model.addAttribute("book", book);
        httpSession.setAttribute("specialBookId", book.getBookId());
        return "user/bookDetail";
    }

    //获取预定列表
    @RequestMapping(value = "/reserveList", method = RequestMethod.GET)
    public String getReserveList(Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        String userId = (String) httpSession.getAttribute("userId");
        ArrayList<reserveBook> reserveList = userservice.queryReserve(userId);
        ArrayList<WebReserveBook> bookList = new ArrayList<WebReserveBook>();
        for (reserveBook reserveBook : reserveList) {
            if (reserveBook.getState() == 0) {
                book book = userservice.queryId(reserveBook.getBookId());
                String createTime = reserveBook.getCreateTime().toString();
                createTime = createTime.substring(0, createTime.length() - 2);

                WebReserveBook webReserveBook = new WebReserveBook();
                webReserveBook.setUserId(userId);
                webReserveBook.setBookId(book.getBookId());
                webReserveBook.setBookName(book.getBookName());
                webReserveBook.setBookWriter(book.getBookWriter());
                webReserveBook.setCreateTime(createTime);
                bookList.add(webReserveBook);
            }
        }
        model.addAttribute("bookList", bookList);
        return "user/reserveList";
    }

    //预定书籍
    @RequestMapping(value = "/doReserve", method = RequestMethod.GET)
    public String doReserve(Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        String userId = (String) httpSession.getAttribute("userId");
        String bookId = (String) httpSession.getAttribute("specialBookId");
        httpSession.removeAttribute("successfullyReserve");
        if (userservice.addReserve(userId, bookId)) {
            httpSession.setAttribute("successfullyReserve", true);
        } else {

        }
        return getReserveList(model, httpSession);
    }

    //取消预定
    @RequestMapping(value = "/{bookId}/{createTime}/doCancelReserve", method = RequestMethod.GET)
    public String cancelReserve(@PathVariable("bookId") String bookId, @PathVariable("createTime") String createTime,
                                Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        String userId = (String) httpSession.getAttribute("userId");
        reserveBook reserveBook = new reserveBook(userId, bookId, Timestamp.valueOf(createTime), 0);
        httpSession.removeAttribute("successfullyCancelReserve");
        if (userservice.deleteReserve(reserveBook)) {
            httpSession.setAttribute("successfullyCancelReserve", true);
        } else {

        }
        return getReserveList(model, httpSession);
    }

    //获取借书列表
    @RequestMapping(value = "/borrowList", method = RequestMethod.GET)
    public String getBorrowList(Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        String userId = (String) httpSession.getAttribute("userId");
        ArrayList<borrowBook> borrowList = userservice.queryBorrow(userId);
        ArrayList<WebBorrowBook> bookList = new ArrayList<WebBorrowBook>();
        for (borrowBook borrowBook : borrowList) {
            if (borrowBook.getState() == 0) {
                book book = userservice.queryId(borrowBook.getBookId());
                System.out.println(borrowBook.getBookId());
                String beginTime = borrowBook.getBeginTime().toString();
                String endTime = borrowBook.getEndTime().toString();
                beginTime = beginTime.substring(0, beginTime.length() - 2);
                endTime = endTime.substring(0, endTime.length() - 2);

                WebBorrowBook webBorrowBook = new WebBorrowBook();
                webBorrowBook.setUserId(userId);
                webBorrowBook.setBookId(borrowBook.getBookId());
                webBorrowBook.setBookName(book.getBookName());
                webBorrowBook.setBookWriter(book.getBookWriter());
                webBorrowBook.setBorrowTime(beginTime);
                webBorrowBook.setReturnTime(endTime);
                bookList.add(webBorrowBook);
            }
        }
        model.addAttribute("bookList", bookList);
        return "user/borrowList";
    }

    //请求还书
    @RequestMapping(value = "/{bookId}/{borrowTime}/doReturnBook")
    public String doReturnBook(@PathVariable("bookId") String bookId, @PathVariable("borrowTime") String borrowTime,
                               Model model, HttpSession httpSession) {
        Integer userType = (Integer) httpSession.getAttribute("userType");
        if (userType == null) return "login";
        else if (userType == 1) return "/admin/searchBook";
        String userId = (String) httpSession.getAttribute("userId");
        httpSession.removeAttribute("successfullyReturn");
        if (userservice.toDropBook(userId, bookId, Timestamp.valueOf(borrowTime))) {
            httpSession.setAttribute("successfullyReturn", true);
        } else {

        }
        return getBorrowList(model, httpSession);
    }
}
