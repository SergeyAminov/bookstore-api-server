package ru.aminov.bookstoreapi.mapper;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.aminov.bookstoreapi.dto.AuthorDto;
import ru.aminov.bookstoreapi.dto.BookDto;
import ru.aminov.bookstoreapi.dto.GenreDto;
import ru.aminov.bookstoreapi.entity.Author;
import ru.aminov.bookstoreapi.entity.Book;
import ru.aminov.bookstoreapi.entity.Genre;
import ru.aminov.bookstoreapi.repository.AuthorRepository;
import ru.aminov.bookstoreapi.repository.BookRepository;
import ru.aminov.bookstoreapi.repository.GenreRepository;

@Component
public class BookMapper {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private GenreRepository genreRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public BookDto toDto(Book book) {

        AuthorDto author = new AuthorDto(
                book.getAuthor().getId(),
                book.getAuthor().getFullName());

        GenreDto genre = new GenreDto(
                book.getGenre().getId(),
                book.getGenre().getGenre());

        return new BookDto(
                book.getId(),
                book.getTitle(),
                author,
                book.getReleaseDate(),
                genre,
                book.getCover(),
                book.getPages(),
                book.getPrice(),
                book.getAmount());
    }

    @SuppressWarnings("null")
    public Book toEntity(BookDto bookDto) {

        Book book = new Book();

        if (!Objects.isNull(bookDto.getId())){
            book = this.bookRepository.findById(bookDto.getId()).get();
        }

        Integer authorId = bookDto.getAuthor().getId();
        Author author = this.authorRepository.findById(authorId).get();

        Integer genreId = bookDto.getGenre().getId();
        Genre genre = this.genreRepository.findById(genreId).get();

        book.setTitle(bookDto.getTitle());
        book.setReleaseDate(bookDto.getReleaseDate());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setCover(bookDto.getCover());
        book.setPages(bookDto.getPages());
        book.setPrice(bookDto.getPrice());

        return book;

    }

}
