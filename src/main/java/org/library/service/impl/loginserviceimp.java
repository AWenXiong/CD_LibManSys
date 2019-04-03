package org.library.service.impl;

import org.library.dao.userdao;
import org.library.entity.user;
import org.library.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginserviceimp implements loginservice {

    @Autowired
    private userdao udao;

    @Override
    public user login(String userId, String passWord) {
        int numb = udao.exist(userId, passWord);
        if (numb > 0) {
            return udao.getUser(userId, passWord);
        } else {
            return null;
        }
    }
}
