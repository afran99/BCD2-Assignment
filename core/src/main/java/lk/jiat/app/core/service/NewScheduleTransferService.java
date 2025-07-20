package lk.jiat.app.core.service;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.NewScheduleTransfer;

import java.util.List;

@Remote
public interface NewScheduleTransferService {

    NewScheduleTransfer getNewScheduleTransferId(Long id);
    List<NewScheduleTransfer> getAllUsNewScheduleTransfers(Long id);
    List<NewScheduleTransfer> getAllNewScheduleTransfers();

    void addNewScheduleTransfer(NewScheduleTransfer newScheduleTransfer);
    void updateNewScheduleTransfer(NewScheduleTransfer newScheduleTransfer);
    void deleteNewScheduleTransfer(Long id);
}
