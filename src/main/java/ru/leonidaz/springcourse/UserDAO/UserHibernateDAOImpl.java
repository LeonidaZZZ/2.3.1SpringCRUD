package ru.leonidaz.springcourse.UserDAO;

import org.springframework.stereotype.Repository;
import ru.leonidaz.springcourse.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserHibernateDAOImpl implements UserDAO {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public void save(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public List<User> allUsers() {
        EntityManager em = emf.createEntityManager();
        Query named = em.createQuery("select u from User u", User.class);
        return named.getResultList();
    }

    @Override
    public User showById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public void edit(int id, User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User newUser = em.find(User.class,id);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        em.merge(newUser);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class,id));
        em.getTransaction().commit();
    }
}
