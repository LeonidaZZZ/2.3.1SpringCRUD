package ru.leonidaz.springcourse.userDAO;

import org.springframework.stereotype.Repository;
import ru.leonidaz.springcourse.models.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserHibernateDAOImpl implements UserDAO {

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> allUsers() {
        Query named = em.createQuery("select u from User u", User.class);
        return named.getResultList();
    }

    @Override
    public User showById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void edit(int id, User user) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(User.class,id));

    }
}
