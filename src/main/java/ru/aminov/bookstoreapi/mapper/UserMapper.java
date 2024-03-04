package ru.aminov.bookstoreapi.mapper;

import org.springframework.stereotype.Component;

import ru.aminov.bookstoreapi.dto.UserDto;
import ru.aminov.bookstoreapi.entity.User;

@Component
public class UserMapper {
    
    public UserDto toDto(User user) {
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getSurname(),
            user.getUsername(),
            user.getEmail(),
            user.getBirthdate(),
            null,
            "ROLE_USER"
        );
    }

}
