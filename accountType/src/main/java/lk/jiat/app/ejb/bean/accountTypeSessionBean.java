package lk.jiat.app.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import lk.jiat.app.core.model.AccountType;
import lk.jiat.app.core.service.AccountTypeService;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
public class accountTypeSessionBean implements AccountTypeService {

    private static final Logger LOG = Logger.getLogger(accountTypeSessionBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public List<AccountType> getAllAccountType(){
        List<AccountType> accountTypes = null;
        try {
            accountTypes = em.createQuery("SELECT a FROM AccountType a", AccountType.class)
                    .getResultList();
            if (accountTypes.isEmpty()) {
                LOG.log(Level.INFO, "No account types found in database");
                return Collections.emptyList();
            }

            return accountTypes;

        } catch (PersistenceException e) {
            LOG.log(Level.SEVERE, "Error retrieving account types from database", e);
            throw new RuntimeException("Failed to retrieve account types", e);
        }
    }

    @Override
    public AccountType getAccountTypeById(int id) {
        return em.find(AccountType.class, id);
    }

    @Override
    public AccountType getAccountTypeByType(String type) {
        return em.find(AccountType.class, type);
    }

    @Override
    public void addAccountType(AccountType accountType) {
        em.persist(accountType);
    }

    @Override
    public void updateAccountType(AccountType accountType) {
        em.merge(accountType);
    }

    @Override
    public void deleteAccountType(int accountType) {
        em.remove(getAccountTypeById(accountType));
    }
}
