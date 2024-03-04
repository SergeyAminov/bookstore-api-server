package ru.aminov.bookstoreapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private LocalDate birthdate;
    private String token;
    private String role;
}
