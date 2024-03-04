package ru.aminov.bookstoreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.aminov.bookstoreapi.dto.UserDto;
import ru.aminov.bookstoreapi.entity.User;
import ru.aminov.bookstoreapi.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody User user) {
        return this.authService.register(user);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody User user) {
        return this.authService.login(user);
    }

}
