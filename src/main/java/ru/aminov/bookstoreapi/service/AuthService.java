package ru.aminov.bookstoreapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.aminov.bookstoreapi.dto.UserDto;
import ru.aminov.bookstoreapi.entity.User;
import ru.aminov.bookstoreapi.mapper.UserMapper;

@Service
public class AuthService {
    private UserMapper userMapper;
    private UserService userService;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /* Регистрация пользователя */
    @Transactional
    public UserDto register(User requestUser) {

        User user = new User();
        user.setUsername(requestUser.getUsername());
        user.setEmail(requestUser.getEmail());
        user.setPassword(this.passwordEncoder.encode(requestUser.getPassword()));

        User created = this.userService.create(user);
        UserDto dto = this.userMapper.toDto(created);
        var jwt = this.jwtService.generateToken(user);
        dto.setToken(jwt);
        return dto;
    }

    /* Аутентификация пользователя */
    @Transactional
    public UserDto login(User requestUser) {

        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            requestUser.getUsername(),
            requestUser.getPassword()
        ));

        User user = this.userService.findByUsername(requestUser.getUsername());
        UserDto dto = this.userMapper.toDto(user);
        String jwt = this.jwtService.generateToken(user);
        dto.setToken(jwt);
        return dto;
    }
}
