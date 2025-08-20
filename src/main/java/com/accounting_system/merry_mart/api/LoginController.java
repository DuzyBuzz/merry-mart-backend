package com.accounting_system.merry_mart.api;

import com.accounting_system.merry_mart.model.LoginRequest;
import com.accounting_system.merry_mart.model.Users;
import com.accounting_system.merry_mart.repository.PaymentRepo;
import com.accounting_system.merry_mart.repository.UsersRepo;
import com.accounting_system.merry_mart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        try{
            Users user = userService.login(request.getUserName(), request.getPassword());
            return ResponseEntity.ok(user);
        }
        catch (RuntimeException e )
        {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(("Invalid credentials"));
        }
    }
}
