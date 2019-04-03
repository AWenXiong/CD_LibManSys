package org.library.dao;

import org.apache.ibatis.annotations.Param;
import org.library.entity.book;

import java.util.ArrayList;

public interface bookdao {

    public int exist(@Param("bookName") String bookName, @Param("bookWriter") String bookWriter, @Param("bookPress") String bookPress, @Param("bookType") String bookType);

    public int exist1(@Param("bookId") String bookId);

    public int addBook(@Param("bookId") String bookId, @Param("bookName") String bookName, @Param("bookWriter") String bookWriter, @Param("bookPress") String bookPress, @Param("bookType") String bookType, @Param("bookStock") int bookStock, @Param("bookTotal") int bookTotal);

    public int deleteBook(String bookId);

    public int update(@Param("bookId") String bookId, @Param("bookName") String bookName, @Param("bookWriter") String bookWriter, @Param("bookPress") String bookPress, @Param("bookType") String bookType, @Param("bookStock") int bookStock, @Param("bookTotal") int bookTotal);

    public ArrayList<book> queryById(String bookId);

    public ArrayList<book> queryByName(String bookName);

    public ArrayList<book> queryByWriter(String bookWriter);

    public ArrayList<book> queryByPress(String bookPress);

    public ArrayList<book> queryByType(String bookType);

    public String getBookId(@Param("bookName") String bookName, @Param("bookWriter") String bookWriter, @Param("bookPress") String bookPress, @Param("bookType") String bookType);

    public book getBook(String bookId);

    public String getMaxId();
}