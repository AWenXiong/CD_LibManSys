package org.library.entity;

import java.sql.Timestamp;
import java.util.Date;

public class dropBook {
    private String readerId;
    private String bookId;
    private Timestamp createTime;
    private Integer state;


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "dropBook{" +
                "readerId='" + readerId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", currentTime=" + createTime +
                ", state=" + state +
                '}';
    }

    public dropBook(String readerId, String bookId, Timestamp createTime, Integer state) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.createTime = createTime;
        this.state = state;
    }
}
