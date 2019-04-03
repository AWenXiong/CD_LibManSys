package org.library.service;

import org.library.entity.book;
import org.library.entity.dropBook;
import org.library.entity.reserveBook;
import org.library.entity.user;

import java.util.ArrayList;
import java.util.HashSet;

public interface adminservice {

    /**
     * Find out the book which has been booked in reserveBook table
     *
     * @return
     */
    public ArrayList<reserveBook> queryReserve();

    /**
     * Getbook's total information from table book with any column of its entry
     *
     * @param information
     * @return
     */
    public HashSet<book> queryBook(String information);

    /**
     * 精确查询图书ID 只返回一本书
     *
     * @param information
     * @return
     */
    public book queryId(String information);

    /**
     * Update this Book's entry to tempbook
     *
     * @param tempbook
     * @return return is always true when no exception happen
     */
    public boolean updateBook(book tempbook);

    /**
     * 1.You have to check whether this kind of book has existed in book table
     * 2.If it has already existed, increase its bookstock
     * 3.If not, add this book's entry and then increase its book stock
     *
     * @return return is always true when no exception happen
     */
    public boolean addBook(String bookName, String bookWriter, String bookPress, String bookType, int number);

    /**
     * Find out whether the book with its bookId existed in book table
     *
     * @param tempbook
     * @return return is always true when no exception happen
     */
    public boolean exist(book tempbook);

    /**
     * Delete this book's entry from book table directly;
     *
     * @param bookid
     * @return return is always true when no exception happen
     */
    public boolean deleteBook(String bookid);

    /**
     * 1.Decrease bookTotal in book table. In other words, bookTotal -= 1
     * 2.Add entry of it in borrowBook table
     * 3.Delete its entry in reserveBook table
     *
     * @return return is always true when no exception happen
     */
    public boolean agreeLend(reserveBook rbook);

    /**
     * Get every entry in dropBook table
     *
     * @return
     */
    public ArrayList<dropBook> queryDrop();

    /**
     * 1.Increase its bookStock in book table
     * 2.Delete its entry in borrowBook table
     * 3.Delete its entry in dropBook
     *
     * @return return is always true when no exception happen
     */
    public boolean agreeDrop(dropBook dpbook);

    /**
     * Add entry in user table
     *
     * @return return is always true when no exception happen
     */
    public boolean addUser(String userName, String userPassWord, int type);

    /**
     * Delete entry in user table
     *
     * @return return is always true when no exception happen
     */
    public boolean deleteUser(String userId);

    /**
     * Change this user information to u.
     *
     * @param u
     * @return return is always true when no exception happen
     */
    public boolean updateUserInformation(user u);

    public user getUser(String userId);
}