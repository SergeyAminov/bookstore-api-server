package ru.aminov.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.aminov.bookstoreapi.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{ }
