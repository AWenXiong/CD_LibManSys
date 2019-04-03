package org.library.dao;

import org.library.entity.reserveBook;

import java.util.ArrayList;

public interface reserveBookdao {

    public int addReserveBook(reserveBook rb);

    public int deleteReserveBook(reserveBook rb);

    public ArrayList<reserveBook> query();

    public ArrayList<reserveBook> query1(String userId);

}
