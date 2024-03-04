package ru.aminov.bookstoreapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.aminov.bookstoreapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value = "SELECT user FROM User user WHERE user.username = :username")
    public Optional<User> loadUserByUsername(@Param("username") String username);

    @Query(value = "SELECT user FROM User user WHERE user.username = :username")
    public User findByUsername(@Param("username") String username);

    public boolean existsByUsername(String username);

}
