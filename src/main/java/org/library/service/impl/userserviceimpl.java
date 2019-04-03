package org.library.service.impl;

import org.library.dao.*;
import org.library.entity.book;
import org.library.entity.borrowBook;
import org.library.entity.dropBook;
import org.library.entity.reserveBook;
import org.library.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@Service
public class userserviceimpl implements userservice {

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
    public org.library.entity.book queryId(String information) {
        ArrayList<book> temp = bdao.queryById(information);
        return temp.get(0);
    }

    @Override
    public HashSet<book> querybook(String information) {
        HashSet<book> ret = new HashSet<book>();
        ArrayList<book> temp = new ArrayList<book>();

        String IDinformation = information;
        information = "%" + information + "%";
        //System.out.println(information);
        temp = bdao.queryByWriter(information);
        for (int i = 0; i < temp.size(); ++i)
            ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryByType(information);
        for (int i = 0; i < temp.size(); ++i)
            ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryByPress(information);
        for (int i = 0; i < temp.size(); ++i)
            ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryByName(information);
        for (int i = 0; i < temp.size(); ++i)
            ret.add(temp.get(i));
        temp.clear();

        temp = bdao.queryById(IDinformation);
        for (int i = 0; i < temp.size(); ++i)
            ret.add(temp.get(i));
        temp.clear();

        return ret;
    }

    @Override
    public ArrayList<borrowBook> queryBorrow(String userid) {

        return bBdao.queryborrow(userid);
    }

    @Override
    public ArrayList<reserveBook> queryReserve(String userid) {

        return rbdao.query1(userid);
    }

    @Override
    public boolean addReserve(String userid, String bookid) {

        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        int state = 0;
        reserveBook rbook = new reserveBook(userid, bookid, createTime, state);
        rbdao.addReserveBook(rbook);
        return true;
    }

    @Override
    public boolean deleteReserve(reserveBook rbook) {
        rbdao.deleteReserveBook(rbook);
        return true;
    }

    @Override
    public boolean toDropBook(String userId, String bookId, Timestamp createTime) {
        int state = 1;
        dropBook dpbook = new dropBook(userId, bookId, createTime, state);
        dBdao.addDrop(dpbook);
        return true;
    }
}