package ru.aminov.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.aminov.bookstoreapi.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{ }
