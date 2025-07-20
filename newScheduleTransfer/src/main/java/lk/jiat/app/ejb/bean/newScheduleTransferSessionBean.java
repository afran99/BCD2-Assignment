package lk.jiat.app.ejb.bean;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.NewScheduleTransfer;
import lk.jiat.app.core.service.NewScheduleTransferService;

import java.util.List;
import java.util.UUID;

@Stateless
public class newScheduleTransferSessionBean implements NewScheduleTransferService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private TimerService timerService;
    @Inject
    private TransferMoney transferAmmount;
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

        String taskId = UUID.randomUUID().toString();

        TimerConfig config = new TimerConfig();
        config.setPersistent(true);
        config.setInfo(taskId);

        if (newScheduleTransfer.getFrequency().equals(2)){
            ScheduleExpression schedule = new ScheduleExpression()
                    .dayOfMonth("1")
                    .hour(0)
                    .minute(0)
                    .second(0);
            em.persist(newScheduleTransfer);
            timerService.createCalendarTimer(schedule, config);
        }
        if (newScheduleTransfer.getFrequency().equals(3)){
            ScheduleExpression schedule = new ScheduleExpression()
                    .month("1")
                    .dayOfMonth("1")
                    .hour(0)
                    .minute(0)
                    .second(0);
            em.persist(newScheduleTransfer);
            timerService.createCalendarTimer(schedule, config);

        }


    }

    @Override
    public void updateNewScheduleTransfer(NewScheduleTransfer newScheduleTransfer) {
        em.merge(newScheduleTransfer);
    }

    @Override
    public void deleteNewScheduleTransfer(Long id) {
        em.remove(getNewScheduleTransferId(id));

    }

    @Timeout
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void handleTimeout(Timer timer) {
        String taskId = (String) timer.getInfo();
        NewScheduleTransfer transfer = em.createQuery("SELECT s FROM NewScheduleTransfer s WHERE s.taskId = :id", NewScheduleTransfer.class)
                .setParameter("id", taskId)
                .getSingleResult();

        if (transfer != null) {
            transferAmmount.debitToAccount(Integer.parseInt(transfer.getFromAccount()),transfer.getAmount());
            transferAmmount.creditToAccount(Integer.parseInt(transfer.getToAccount()),transfer.getAmount());
        }
    }


}
