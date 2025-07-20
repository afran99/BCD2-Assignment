package lk.jiat.app.core.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ScheduledTransfer")
@NamedQueries({
        @NamedQuery(name = "NewScheduleTransfer.findById", query = "select nst from NewScheduleTransfer nst where nst.id=:id"),
        @NamedQuery(name = "NewScheduleTransfer.findAll", query = "select nst from NewScheduleTransfer nst")
})
public class NewScheduleTransfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskId;
    private String frequency;
    private String fromAccount;
    private String toAccount;
    private double amount;
    private Date transferTime;
    private String transactionId;

    public NewScheduleTransfer() {
    }

    public NewScheduleTransfer(Long id, String taskId, String frequency, String fromAccount, String toAccount, double amount, Date transferTime, String transactionId) {
        this.id = id;
        this.taskId = taskId;
        this.frequency = frequency;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.transferTime = transferTime;
        this.transactionId = transactionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
