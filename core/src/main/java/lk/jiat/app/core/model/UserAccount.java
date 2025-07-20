package lk.jiat.app.core.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "userAccount")
@NamedQueries({
        @NamedQuery(name = "UserAccount.findByEmail", query = "select u from UserAccount u where u.email=:email"),
        @NamedQuery(name = "UserAccount.findAll", query = "select u from UserAccount u"),
        @NamedQuery(name = "UserAccount.findByAccountType", query = "select u from UserAccount u where u.accountType.type =:accountType")

})
public class UserAccount implements Serializable {

    @Id
    private int accountNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date birthDate;
    private Date createdDate;
    private String status;
    private Double balance;

    public UserAccount() {
    }

    public UserAccount(int accountNumber, String firstName, String lastName, String email, String phone, String address, Date birthDate, Date createdDate, String status, Double balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
        this.createdDate = createdDate;
        this.status = status;
        this.balance = balance;
        this.accountType = accountType;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private AccountType accountType;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreatedDate(Date date) {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
