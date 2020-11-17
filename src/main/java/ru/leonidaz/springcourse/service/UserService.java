package ru.leonidaz.springcourse.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.leonidaz.springcourse.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUsers();
    User showById(int id);
    void save(User user);
    void edit(int id, User user);
    void delete(int id);
}
