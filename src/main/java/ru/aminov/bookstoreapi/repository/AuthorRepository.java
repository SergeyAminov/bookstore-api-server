package ru.aminov.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.aminov.bookstoreapi.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{ }
