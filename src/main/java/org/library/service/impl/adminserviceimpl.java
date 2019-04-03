package org.library.service.impl;

import org.library.dao.*;
import org.library.entity.*;
import org.library.service.adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

@Service
public class adminserviceimpl implements adminservice {

    @Autowired
    private reserveBookdao rbdao;
    @Autowired
    private bookdao bdao;
    @Autowired
    private borrowBookdao bBdao;
    @Autowired
    private dropBookdao dBdao;
    @Autowired
    private userdao udao;

    @Override
    public ArrayList<reserveBook> queryReserve() {
        return rbdao.query();
    }


    @Override
    public org.library.entity.book queryId(String information) {
        ArrayList<book> temp = bdao.queryById(information);
        return temp.get(0);
    }

    @Override
    public HashSet<book> queryBook(String information) {
        HashSet<book> ret = new HashSet<book>();
        ArrayList<book> temp = new ArrayList<book>();

        String IDinformation = information;
        information = "%" + information + "%";
        temp = bdao.queryByName(information);
        for (int i = 0; i < temp.size(); ++i) ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryByPress(information);
        for (int i = 0; i < temp.size(); ++i) ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryByType(information);
        for (int i = 0; i < temp.size(); ++i) ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryByWriter(information);
        for (int i = 0; i < temp.size(); ++i) ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryById(IDinformation);
        for (int i = 0; i < temp.size(); ++i) ret.add(temp.get(i));
        temp.clear();
        return ret;
    }

    @Override
    public boolean updateBook(book tempbook) {
        String bookId = tempbook.getBookId();
        String bookName = tempbook.getBookName();
        String bookWriter = tempbook.getBookWriter();
        String bookPress = tempbook.getBookPress();
        String bookType = tempbook.getBookType();
        int bookStock = tempbook.getBookStock();
        int bookTotal = tempbook.getBookTotal();
        bdao.update(bookId, bookName, bookWriter, bookPress, bookType, bookStock, bookTotal);
        return true;
    }

    @Override
    @Transactional
    public boolean addBook(String bookName, String bookWriter, String bookPress, String bookType, int number) {
        int numb = bdao.exist(bookName, bookWriter, bookPress, bookType);

        if (numb > 0) {
            String bookId = bdao.getBookId(bookName, bookWriter, bookPress, bookType);
            book temp = bdao.getBook(bookId);
            bdao.update(bookId, bookName, bookWriter, bookPress, bookType, number + temp.getBookStock(), number + temp.getBookTotal());
        } else {
            String bookId = getNewBookId();
            bdao.addBook(bookId, bookName, bookWriter, bookPress, bookType, number, number);
        }
        return true;
    }

    @Override
    public boolean exist(book tempbook) {
        return true;
    }

    @Override
    @Transactional
    public boolean deleteBook(String bookid) {
        int numb = bdao.exist1(bookid);
        if (numb == 0) return false;
        else {
            bdao.deleteBook(bookid);
            return true;
        }
    }

    @Override
    //此函数经孙昊修改过 与9.13晚
    @Transactional
    public boolean agreeLend(reserveBook rbook) {
        String bookId = rbook.getBookId();
        Timestamp createTime = rbook.getCreateTime();
        String readerId = rbook.getReaderId();
        Integer state = rbook.getState();

        book temp = bdao.getBook(bookId);
        if (temp.getBookStock() == 0) return false;
        temp.setBookStock(temp.getBookStock() - 1);
        bdao.update(temp.getBookId(), temp.getBookName(), temp.getBookWriter(), temp.getBookPress(), temp.getBookType(), temp.getBookStock(), temp.getBookTotal());
        Long td = 30 * 24 * 60 * 60 * 1000l;
        Timestamp endTime = new Timestamp(createTime.getTime() + td);
        bBdao.addborrow(new borrowBook(readerId, bookId, createTime, endTime, rbook.getState()));
        rbdao.deleteReserveBook(rbook);
        return true;
    }

    @Override
    @Transactional
    public ArrayList<dropBook> queryDrop() {
        return dBdao.queryDropBook();
    }

    @Override
    @Transactional
    public boolean agreeDrop(dropBook dpbook) {
        String userId = dpbook.getReaderId();
        String bookId = dpbook.getBookId();
        //Date createTime = dpbook.getCreateTime(); 孙昊修改
        Timestamp createTime = dpbook.getCreateTime();
        int state = dpbook.getState();

        book b = bdao.getBook(bookId);
        b.setBookStock(b.getBookStock() + 1);
        bdao.update(b.getBookId(), b.getBookName(), b.getBookWriter(), b.getBookPress(), b.getBookType(), b.getBookStock(), b.getBookTotal());
        borrowBook tmp = bBdao.getBorrowBook(bookId, userId, createTime);
        bBdao.deleteborrow(tmp);
        dBdao.deleteDrop(dpbook);
        return true;
    }

    @Override
    @Transactional
    public boolean addUser(String userName, String userPassWord, int type) {
        String userId = getNewUserId();
        udao.addUser(new user(userId, userName, userPassWord, type));
        return true;
    }

    @Override
    @Transactional
    public boolean deleteUser(String userId) {
        udao.deleteUser(userId);
        return true;
    }

    @Override
    @Transactional
    public boolean updateUserInformation(user u) {
        udao.update(u);
        return true;
    }

    @Transactional
    public user getUser(String userId) {
        return udao.queryUser(userId);
    }


    private String getNewUserId() {
        String ret = udao.getMaxId();
        Integer newid = (Integer.parseInt(ret) + 1);
        ret = String.valueOf(newid);
        return ret;
    }

    private String getNewBookId() {
        String ret = bdao.getMaxId();
        System.out.println("ret = " + ret);
        Integer newid = (Integer.parseInt(ret) + 1);
        ret = String.valueOf(newid);
        return ret;
    }

}