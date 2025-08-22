package com.accounting_system.merry_mart.dto;

import java.util.UUID;

public class UserResponse {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String role;

    public UserResponse() {}

    public UserResponse(UUID userId, String firstName, String lastName, String userName, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.role = role;
    }

    // Getters & Setters
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
