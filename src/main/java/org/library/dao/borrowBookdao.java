package org.library.dao;

import org.apache.ibatis.annotations.Param;
import org.library.entity.borrowBook;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public interface borrowBookdao {

    public borrowBook getBorrowBook(@Param("bookId") String bookId, @Param("readerId") String readerId, @Param("beginTime") Timestamp beginTime);

    public int addborrow(borrowBook t);

    public int deleteborrow(borrowBook t);

    public ArrayList<borrowBook> queryborrow(String readerId);

}
