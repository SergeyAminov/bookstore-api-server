package ru.aminov.bookstoreapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ru.aminov.bookstoreapi.entity.Role;
import ru.aminov.bookstoreapi.entity.User;
import ru.aminov.bookstoreapi.entity.UserRole;
import ru.aminov.bookstoreapi.repository.RoleRepository;
import ru.aminov.bookstoreapi.repository.UserRepository;
import ru.aminov.bookstoreapi.repository.UserRoleRepository;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    public User create(User user) throws RuntimeException {

        if (this.userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        // По умолчанию все пользователи имеют лишь базовую роль "ROLE_USER"
        Role role = this.roleRepository.findById(2).get();
        User created = this.userRepository.save(user);
        UserRole userRole = new UserRole(created, role);

        this.userRoleRepository.save(userRole);

        return created;
    }

    @Transactional
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.loadUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден."));
    }

}
