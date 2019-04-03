package org.library.dao;

import org.apache.ibatis.annotations.Param;
import org.library.entity.user;

import java.util.ArrayList;

public interface userdao {
    public int addUser(user u);

    public int deleteUser(String userId);

    public int update(user u);

    public ArrayList<user> query();

    public user getUser(@Param("userId") String userId, @Param("userPassWord") String userPassWord);

    public int exist(@Param("userId") String userId, @Param("userPassWord") String userPassWord);

    public String getMaxId();

    public user queryUser(String userId);

}