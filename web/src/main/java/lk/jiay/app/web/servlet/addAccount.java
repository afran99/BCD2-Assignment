package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
@ServletSecurity(@HttpConstraint(rolesAllowed = {"ADMIN"}))
@WebServlet("/addAccount")
public class addAccount extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(addAccount.class.getName());
    @Inject
    private AccountTypeService accountTypeService;

    @EJB
    private UserAccountService userAccountService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String acType = request.getParameter("accountType");
        String balance = request.getParameter("balance");
        Date birthDay = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthDay = dateFormat.parse(dob);
        } catch (Exception e){
            log("a");
        }

        AccountType accountType = null;
        try {
            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
            request.setAttribute("accountTypes", accountTypes);

        }catch (NumberFormatException e){
            log("Account type not found");
        }

        int accountNumber;
        Random random = new Random();
        do {
            accountNumber = 10000000 + random.nextInt(90000000);
            LOG.info(String.valueOf(accountNumber));
        } while (userAccountService.getAllUserAccount(accountNumber) != null);

        UserAccount userAccount =  new UserAccount();
        userAccount.setAccountNumber(accountNumber);
        userAccount.setFirstName(firstName);
        userAccount.setLastName(lastName);
        userAccount.setEmail(email);
        userAccount.setPhone(phone);
        userAccount.setAddress(address);
        userAccount.setBirthDate(birthDay);
        userAccount.setAccountType(accountType);
        userAccount.setBalance(Double.parseDouble(balance));
        userAccount.getCreatedDate(new Date());

        response.sendRedirect(request.getContextPath()+"/admin/customerAccount.jsp");

    }
}
