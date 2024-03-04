package ru.aminov.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.aminov.bookstoreapi.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{ }
