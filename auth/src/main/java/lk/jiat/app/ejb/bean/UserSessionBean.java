package lk.jiat.app.ejb.bean;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.User;
import lk.jiat.app.core.service.UserServise;

@Stateless
public class UserSessionBean implements UserServise {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
       return em.createNamedQuery("User.findByEmail",User.class)
               .setParameter(1, email).getSingleResult();

    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public boolean validate(String email, String password) {
        User user = em.createNamedQuery("User.findByEmail", User.class)
                .setParameter(1, email).getSingleResult();
        return user != null && user.getPassword().equals(password) ;
    }
}