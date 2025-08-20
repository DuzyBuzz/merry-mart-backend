package com.accounting_system.merry_mart.model;

import java.util.UUID;

public class Users {
    private  final UUID userId;
    private final  String firstName;
    private final  String lastName;
    private final  String position;
    private final  String userName;
    private final  String password;

    public Users(UUID userId, String firstName, String lastName, String position, String userName, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.userName = userName;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
