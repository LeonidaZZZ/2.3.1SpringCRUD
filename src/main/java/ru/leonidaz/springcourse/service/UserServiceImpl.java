package ru.leonidaz.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.leonidaz.springcourse.userDAO.UserDAO;
import ru.leonidaz.springcourse.models.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public User showById(int id) {
        return userDAO.showById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void edit(int id, User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.edit(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }


    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        return userDAO.findByName(firstName);
    }

    @Override
    public User findByName(String firstname) {
        return userDAO.findByName(firstname);
    }
}
