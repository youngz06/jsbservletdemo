package com.zyoungBlog.beans;

/**
 * Created by youngz on 16-8-18.
 */
public class UserAccount {
    private String userName;
    private String passwd;
    private String gender;
    public void UserAccount() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
