package com.example.grosury.Model;

public class UserFile {

    String userName,email,mobile,address,password,confirmPass,userId,lastMessage;

    public UserFile( String userName, String email,String mobile,String address, String password, String confirmPass) {

        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
        this.confirmPass=confirmPass;
    }


    public UserFile(){}

    //Signup ke liye alag se constructor banayenge
    //Aur yahi teeno chheezo ko hum firebase me le jane wale hai
    public UserFile( String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId(String key) {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
