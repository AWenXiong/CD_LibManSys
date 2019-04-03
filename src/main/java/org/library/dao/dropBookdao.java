package org.library.dao;

import org.library.entity.dropBook;

import java.util.ArrayList;

public interface dropBookdao {

    public int addDrop(dropBook db);

    public int deleteDrop(dropBook db);

    public ArrayList<dropBook> queryDropBook();

}
