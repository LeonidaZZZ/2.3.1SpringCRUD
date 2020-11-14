package ru.leonidaz.springcourse.UserDAO;


import ru.leonidaz.springcourse.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private final List<User> users = new ArrayList<>();
    private static int COUNT;
//    {
//        users = new ArrayList<>();
//        users.add(new User(++COUNT,"UserName1","UserLastName1","user1@mail.ru"));
//        users.add(new User(++COUNT,"UserName2","UserLastName2","user1@mail.ru"));
//        users.add(new User(++COUNT,"UserName3","UserLastName3","user1@mail.ru"));
//    }
    @Override
    public List<User> allUsers(){
        return users;
    }
    public User showById(int id){
        return users.stream().filter(user -> user.getId()==(id)).findAny().orElse(null);
    }
    @Override
    public void save(User user){
        user.setId(++COUNT);
        users.add(user);
    }
    @Override
    public void edit(int id, User user){
        User newUser = showById(id);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
    }
    @Override
    public void delete(int id){
        users.removeIf(user -> user.getId() == id);
    }
}

