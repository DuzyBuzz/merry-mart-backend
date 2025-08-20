package com.accounting_system.merry_mart.service;

import com.accounting_system.merry_mart.model.Users;
import com.accounting_system.merry_mart.repository.UsersRepo;
import jakarta.persistence.Access;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public Users login(String userName, String password){
        Optional<Users> usersOptional = usersRepo.findByUserName(userName);

        if(usersOptional.isPresent() && usersOptional.get().getPassword().equals(password)) {
            return usersOptional.get();
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}

