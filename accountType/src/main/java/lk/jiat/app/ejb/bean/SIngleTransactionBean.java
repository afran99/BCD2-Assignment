package lk.jiat.app.ejb.bean;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.SIngleTransaction;
import lk.jiat.app.core.service.SingleTransactionSession;

import java.util.List;

@Stateless
public class SIngleTransactionBean implements SingleTransactionSession {

    @EJB
    private MoneyTransfer moneyTransfer;

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<SIngleTransaction> getSingleTransactionList() {
        List<SIngleTransaction> sIngleTransactions = em.createQuery("FROM SIngleTransaction",SIngleTransaction.class).getResultList();
        return sIngleTransactions;
    }

    @Override
    public SIngleTransaction getTransaction(String taskId) {
        SIngleTransaction sIngleTransaction = em.createQuery("SELECT a from SIngleTransaction a WHERE a.TaskId = : taskId",SIngleTransaction.class).getSingleResult();
        return sIngleTransaction;
    }

    @Override
    public void addTranasaction(SIngleTransaction transaction) {
        transactionMetiord(transaction);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    private void transactionMetiord(SIngleTransaction sIngleTransaction){
        moneyTransfer.creditToAccount(Integer.parseInt(sIngleTransaction.getToAccount()),sIngleTransaction.getAmount());
        moneyTransfer.debitToAccount(Integer.parseInt(sIngleTransaction.getFromAccount()),sIngleTransaction.getAmount());
        em.persist(sIngleTransaction);
    }
}
