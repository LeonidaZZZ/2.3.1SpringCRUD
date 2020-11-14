package ru.leonidaz.springcourse.service;

import org.springframework.stereotype.Component;
import ru.leonidaz.springcourse.UserDAO.UserDAO;
import ru.leonidaz.springcourse.UserDAO.UserDAOImpl;
import ru.leonidaz.springcourse.models.User;

import java.util.List;

@Component
public class ServiceImpl implements Service{
    private final UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public User showById(int id) {
        return userDAO.showById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void edit(int id, User user) {
        userDAO.edit(id, user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
