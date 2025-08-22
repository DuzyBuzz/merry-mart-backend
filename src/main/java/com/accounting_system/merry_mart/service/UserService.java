package com.accounting_system.merry_mart.service;

import com.accounting_system.merry_mart.dto.LoginRequest;
import com.accounting_system.merry_mart.dto.UserRequest;
import com.accounting_system.merry_mart.dto.UserResponse;
import com.accounting_system.merry_mart.model.Users;
import com.accounting_system.merry_mart.repository.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    // Login method
    public UserResponse login(LoginRequest loginRequest) {
        Users user = usersRepo.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());

        if (user == null) {
            return null; // or throw a custom exception
        }

        // Map Users entity to DTO
        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getRole()
        );
    }
    // Create User
    public UserResponse createUser(UserRequest request) {
        Users user = new Users(
                request.getFirstName(),
                request.getLastName(),
                request.getPosition(),
                request.getUserName(),
                request.getPassword(), // In production, hash the password
                request.getRole()
        );

        usersRepo.createUser(user);

        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getRole()
        );
    }

    // Get All Users
    public List<UserResponse> getAllUsers() {
        return usersRepo.findAll().stream()
                .map(user -> new UserResponse(
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUserName(),
                        user.getRole()))
                .toList();
    }

    // Get User By ID
    public UserResponse getUserById(UUID id) {
        Users user = usersRepo.findById(id);
        if (user == null) return null;

        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getRole()
        );
    }

    // Update User
    public UserResponse updateUser(UUID id, UserRequest request) {
        Users existingUser = usersRepo.findById(id);
        if (existingUser == null) return null;

        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setPosition(request.getPosition());
        existingUser.setUserName(request.getUserName());
        existingUser.setPassword(request.getPassword());
        existingUser.setRole(request.getRole());

        usersRepo.update(existingUser);

        return new UserResponse(
                existingUser.getUserId(),
                existingUser.getFirstName(),
                existingUser.getLastName(),
                existingUser.getUserName(),
                existingUser.getRole()
        );
    }

    // Delete User
    public boolean deleteUser(UUID id) {
        return usersRepo.deleteById(id);
    }

}
