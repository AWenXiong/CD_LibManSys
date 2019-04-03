package org.library.service;

import org.library.entity.book;
import org.library.entity.borrowBook;
import org.library.entity.dropBook;
import org.library.entity.reserveBook;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

public interface userservice {
    /**
     * 1.To judge if this man exist, if not return 0;
     * 2.If this man is admin, return 2; else return 1;
     * @param username
     * @param password
     * @return
     */

    /**
     * Get every book in book table with any column information match param
     *
     * @param information
     * @return
     */
    public HashSet<book> querybook(String information);

    /**
     * 精确查询图书ID 只返回一本书
     *
     * @param information
     * @return
     */
    public book queryId(String information);

    /**
     * Get every entry of this user in borrowBook table
     *
     * @param userid
     * @return
     */
    public ArrayList<borrowBook> queryBorrow(String userid);

    /**
     * Get every entry of this user in reserveBook table
     *
     * @param userid
     * @return
     */
    public ArrayList<reserveBook> queryReserve(String userid);

    /**
     * As a user, if you would like to borrow a book, you have to add an entry in borrowBook table, and then
     * wait for admin to agree
     *
     * @param userid
     * @param bookid
     * @return return is always true when no expectation happen.
     */
    public boolean addReserve(String userid, String bookid);

    /**
     * As an user, if you regreted for your borrow, you can delete it from reserveBook table
     *
     * @return return is always true when no expectation happen.
     */
    public boolean deleteReserve(reserveBook rbook);

    /**
     * Add your entry in dropBook table
     *
     * @return return is always true when no expectation happen.
     */
    public boolean toDropBook(String userId, String bookId, Timestamp createTime);
}