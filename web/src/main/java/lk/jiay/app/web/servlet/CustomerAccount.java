package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.AccountType;
import lk.jiat.app.core.model.UserAccount;
import lk.jiat.app.core.service.AccountTypeService;
import lk.jiat.app.core.service.UserAccountService;

import java.io.IOException;
import java.util.List;

@WebServlet("/customerAccount")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"ADMIN"}))
public class CustomerAccount extends HttpServlet {
    @EJB
    private AccountTypeService accountTypeService;

    @EJB
    private UserAccountService userAccountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("ok");

        try {

            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
            List<UserAccount> userAccounts = userAccountService.getAllUserAccount();
            for (UserAccount account: userAccounts){
                System.out.println(account.getAccountNumber());
            }
            request.setAttribute("accountTypes", accountTypes);
            request.setAttribute("userAccounts", userAccounts);
            request.getRequestDispatcher("/admin/customerAccount.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("error");
        }

    }
}
