package lk.jiat.app.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.UserAccount;

@Stateless
public class MoneyTransfer {
    @PersistenceContext
    private EntityManager em;


    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void creditToAccount(int AccountNumber, double amount) {
        try {
            UserAccount userAccount =em.find(UserAccount.class, AccountNumber);
            if (amount > 0){
                userAccount.setBalance(userAccount.getBalance() + amount);
            }
            em.merge(userAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void debitToAccount(int AccountNumber, double amount) {
        try {
            UserAccount userAccount =em.find(UserAccount.class, AccountNumber) ;
            if (userAccount.getBalance() > amount) {
                userAccount.setBalance(userAccount.getBalance() - amount);
                em.merge(userAccount);
            }else {
                System.out.println("Insuficent Money");
            }

        } catch (Exception e) {

        }
    }
}
