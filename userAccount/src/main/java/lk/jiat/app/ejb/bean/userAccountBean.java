package lk.jiat.app.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.UserAccount;
import lk.jiat.app.core.service.UserAccountService;

import java.util.List;

@Stateless
public class userAccountBean implements UserAccountService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserAccount getUserAccountById(int accountNumber) {
        return em.find(UserAccount.class, accountNumber);
    }

    @Override
    public UserAccount getUserAccountByEmail(String email) {
        return em.createNamedQuery("UserAccount.findByEmail",UserAccount.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<UserAccount> getUserAccountByAccountType(String type) {
        return em.createNamedQuery("UserAccount.findByAccountType",UserAccount.class)
                .setParameter("accountType", type)
                .getResultList();
    }

    @Override
    public List<UserAccount> getAllUserAccount(int accountNumber) {
        return em.createNamedQuery("UserAccount.findAll", UserAccount.class)
                .getResultList();
    }

    @Override
    public void addUserAccount(UserAccount userAccount) {
        em.persist(userAccount);
    }

    @Override
    public void updateUserAccount(UserAccount userAccount) {
        em.merge(userAccount);
    }

    @Override
    public void deleteUserAccount(int accountNumber) {
        em.remove(getUserAccountById(accountNumber));
    }
}
