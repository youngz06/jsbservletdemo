package com.zyoungBlog.beans;

/**
 * Created by youngz on 16-8-18.
 */
public class UserAccount {
    private String username;
    private String passwd;
    private String gender;
    public void UserAccount() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
