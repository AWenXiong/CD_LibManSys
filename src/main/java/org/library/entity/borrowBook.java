package org.library.entity;

import java.sql.Timestamp;
import java.util.Date;

public class borrowBook {
    private String userId;
    private String bookId;
    private Timestamp beginTime;
    private Timestamp endTime;
    private Integer state;

    public String getReaderId() {
        return userId;
    }

    public void setReaderId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "borrowBook{" +
                "readerId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", state=" + state +
                '}';
    }

    public borrowBook(String readerId, String bookId, Timestamp beginTime, Timestamp endTime, Integer state) {
        this.userId = readerId;
        this.bookId = bookId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.state = state;
    }
}
