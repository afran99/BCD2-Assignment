package lk.jiat.app.core.service;

import jakarta.ejb.Remote;
import lk.jiat.app.core.model.AccountType;

import java.util.List;

@Remote
public interface AccountTypeService {
    AccountType getAccountTypeById(int id);
    AccountType getAccountTypeByType(String type);

    void addAccountType(AccountType accountType);
    void updateAccountType(AccountType accountType);
    void deleteAccountType(int accountType);

    List<AccountType> getAllAccountTypes();
}
