package org.library.dto;

import java.sql.Timestamp;
import java.util.Date;

public class WebDropBook {

    private String userId;
    private String bookId;
    private String createTime;
    private Integer state;
    private String userName;
    private String bookName;

    @Override
    public String toString() {
        return "WebDropBook{" +
                "userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                ", userName='" + userName + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
