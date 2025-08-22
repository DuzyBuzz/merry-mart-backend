package com.accounting_system.merry_mart.api;

import com.accounting_system.merry_mart.dto.LoginRequest;
import com.accounting_system.merry_mart.dto.UserResponse;
import com.accounting_system.merry_mart.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        UserResponse user = userService.login(loginRequest);
        if (user == null) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
        return ResponseEntity.ok(user);
    }
}
