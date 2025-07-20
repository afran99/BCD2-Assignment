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

    @EJB
    private AccountTypeService accountTypeService;

    @EJB
    private UserAccountService userAccountService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("add acount ok");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String acType = request.getParameter("accountType");
        String balance = request.getParameter("balance");


        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(dob);
        System.out.println(acType);
        System.out.println(Double.parseDouble(balance));



        Date birthDay = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthDay = dateFormat.parse(dob);
        } catch (Exception e){
            log("Invalid date format");
        }
//
        AccountType accountType = null;
        try {
            int typeId = Integer.parseInt(acType);
            accountType = accountTypeService.getAccountTypeById(typeId);
        } catch (Exception e) {
            log("Account type retrieval failed: " + e.getMessage());
        }
//
        int accountNumber;
        Random random = new Random();
        do {
            accountNumber = 10000000 + random.nextInt(90000000);
            LOG.info(String.valueOf(accountNumber));
        } while (userAccountService.getAllUserAccount(accountNumber) == null);

        double price = 0.0;
        try {
            price = Double.parseDouble(balance);
        } catch (NumberFormatException e) {
            log("Invalid balance");
        }

        Date createdDate = new Date();

        UserAccount userAccount = new UserAccount(accountNumber, firstName, lastName, email,phone, address, birthDay,
                createdDate, "Active", price, accountType);
        userAccountService.addUserAccount(userAccount);

        response.sendRedirect(request.getContextPath()+"/admin/customerAccount.jsp");
//
//        UserAccount userAccount =  new UserAccount();
//        userAccount.setAccountNumber(accountNumber);
//        userAccount.setFirstName(firstName);
//        userAccount.setLastName(lastName);
//        userAccount.setEmail(email);
//        userAccount.setPhone(phone);
//        userAccount.setAddress(address);
//        userAccount.setBirthDate(birthDay);
//        userAccount.setAccountType(accountType);
//        userAccount.setBalance(Double.parseDouble(balance));
//        userAccount.getCreatedDate(new Date());
//
//        response.sendRedirect(request.getContextPath()+"/admin/customerAccount.jsp");

    }
}
