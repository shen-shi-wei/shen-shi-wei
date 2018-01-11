package com.lanou.bookstore.user.domain;

public class User {
    private String uid;
    private String Username;
    private String Password;
    private String email;
    private String code;
    private int state;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User(String username, String password) {
        Username = username;
        Password = password;
    }

    public User(String username, String password, String email) {

        Username = username;
        Password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", state=" + state +
                '}';
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }



    public User() {
    }
}
