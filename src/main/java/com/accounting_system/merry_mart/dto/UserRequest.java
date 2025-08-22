package com.accounting_system.merry_mart.dto;

public class UserRequest {
    private String firstName;
    private String lastName;
    private String position;
    private String userName;
    private String password;
    private String role;

    public UserRequest() {}

    public UserRequest(String firstName, String lastName, String position,
                       String userName, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
