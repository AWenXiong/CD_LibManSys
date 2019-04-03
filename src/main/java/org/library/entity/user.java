package org.library.entity;

public class user {
    private String userId;
    private String userName;
    private String userPassWord;
    private Integer userType;

    /**
     * @return
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassWord + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public user(String userId, String userName, String userPassWord, Integer userType) {
        this.userId = userId;
        this.userName = userName;
        this.userPassWord = userPassWord;
        this.userType = userType;
    }

    public user() {
    }
}
