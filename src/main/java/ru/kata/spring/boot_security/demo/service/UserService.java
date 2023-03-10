package ru.kata.spring.boot_security.demo.service;



import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(Long id);

    public User getUserByUsername(String username);

    public User getUserByEmail(String email);

    public void deleteUser(Long id);

    public void updateUser(Long id, User updatedUser);
}
