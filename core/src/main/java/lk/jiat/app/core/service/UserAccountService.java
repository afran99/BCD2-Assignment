package lk.jiat.app.core.service;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.UserAccount;

import java.util.List;

@Remote
public interface UserAccountService {

    UserAccount getUserAccountById(int accountNumber);
    UserAccount getUserAccountByEmail(String email);
    List<UserAccount> getUserAccountByAccountType(String type);
    List<UserAccount> getAllUserAccount();
    void addUserAccount(UserAccount userAccount);
    void updateUserAccount(UserAccount userAccount);
    void deleteUserAccount(int accountNumber);

}
