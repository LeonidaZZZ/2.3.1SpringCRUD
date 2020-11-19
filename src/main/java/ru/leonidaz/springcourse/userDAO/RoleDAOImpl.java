package ru.leonidaz.springcourse.userDAO;

import org.springframework.stereotype.Repository;
import ru.leonidaz.springcourse.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Role findByID(int id) {
        return em.find(Role.class, id);
    }
}
