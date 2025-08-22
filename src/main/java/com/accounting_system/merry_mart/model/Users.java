package com.accounting_system.merry_mart.model;

import java.util.UUID;

public class Users {

    private UUID userId;      // Maps to user_id CHAR(36) in DB
    private String firstName; // first_name NOT NULL
    private String lastName;  // last_name NOT NULL
    private String position;  // position NULLABLE
    private String userName;  // user_name NOT NULL, UNIQUE
    private String password;  // password NOT NULL
    private String role;      // role NOT NULL

    // Default constructor
    public Users() {
    }

    // Constructor without userId (used when creating new user)
    public Users(String firstName, String lastName, String position,
                 String userName, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    // Constructor with userId (used when retrieving from DB)
    public Users(UUID userId, String firstName, String lastName, String position,
                 String userName, String password, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

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
