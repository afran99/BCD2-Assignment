package lk.jiat.app.core.service;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.SIngleTransaction;

import java.util.List;

@Remote
public interface SingleTransactionSession {
    List<SIngleTransaction> getSingleTransactionList();
    SIngleTransaction getTransaction(String taskId);
    void addTranasaction(SIngleTransaction transaction);
}
