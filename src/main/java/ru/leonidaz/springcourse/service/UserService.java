package ru.leonidaz.springcourse.service;

import ru.leonidaz.springcourse.models.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User showById(int id);
    void save(User user);
    void edit(int id, User user);
    void delete(int id);
}
