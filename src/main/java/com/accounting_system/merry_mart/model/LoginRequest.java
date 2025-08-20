package com.accounting_system.merry_mart.model;

public class LoginRequest {
    private String userName; // must match JSON key
    private String password;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}