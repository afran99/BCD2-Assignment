package lk.jiat.app.ejb.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.NewScheduleTransfer;
import lk.jiat.app.core.service.NewScheduleTransferService;

import java.util.List;

@Stateless
public class newScheduleTransferSessionBean implements NewScheduleTransferService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public NewScheduleTransfer getNewScheduleTransferId(Long id) {
        return em.find(NewScheduleTransfer.class, id);
    }

    @Override
    public List<NewScheduleTransfer> getAllUsNewScheduleTransfers(Long id) {
        return em.createNamedQuery("NewScheduleTransfer.findAll", NewScheduleTransfer.class)
                .getResultList();
    }

    @Override
    public List<NewScheduleTransfer> getAllNewScheduleTransfers() {
        return em.createNamedQuery("NewScheduleTransfer.findAll", NewScheduleTransfer.class)
                .getResultList();
    }

    @Override
    public void addNewScheduleTransfer(NewScheduleTransfer newScheduleTransfer) {
        em.persist(newScheduleTransfer);
    }

    @Override
    public void updateNewScheduleTransfer(NewScheduleTransfer newScheduleTransfer) {
        em.merge(newScheduleTransfer);
    }

    @Override
    public void deleteNewScheduleTransfer(Long id) {
        em.remove(getNewScheduleTransferId(id));

    }
}
