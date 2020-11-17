package ru.leonidaz.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.leonidaz.springcourse.models.Role;
import ru.leonidaz.springcourse.userDAO.UserDAO;
import ru.leonidaz.springcourse.models.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO){
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
        user.setRoles(Collections.singleton(new Role(1,"ROLE_USER")));
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void edit(int id, User user) {
        userDAO.edit(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        User user = userDAO.findByName(firstName);
        if (user == null)
            throw new UsernameNotFoundException("User Not found");

        return user;
    }
}
