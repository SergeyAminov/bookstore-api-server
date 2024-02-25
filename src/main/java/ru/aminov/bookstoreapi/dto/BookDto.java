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
public class BookDto {
    private Integer id;
    private String title;
    private AuthorDto author;
    private LocalDate releaseDate;
    private GenreDto genre;
    private String cover;
    private Integer pages;
    private Integer price;
    private Integer amount;
}
