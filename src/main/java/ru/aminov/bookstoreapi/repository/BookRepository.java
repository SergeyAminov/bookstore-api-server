package ru.aminov.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.aminov.bookstoreapi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{ }
