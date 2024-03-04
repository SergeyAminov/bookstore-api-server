package ru.aminov.bookstoreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok(this.authService.register(user));
        } catch (RuntimeException e) {
            return ResponseEntity.ok("Пользователь с такой почтой уже существует");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            return ResponseEntity.ok(this.authService.login(user));
        } catch (AuthenticationException e) {
            return ResponseEntity.ok("Неверный пароль");
        } catch (RuntimeException e) {
            return ResponseEntity.ok("Неверное имя пользователя");
        }
    }

}
