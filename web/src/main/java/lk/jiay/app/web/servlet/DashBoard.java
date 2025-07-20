package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.AccountType;
import lk.jiat.app.core.model.UserAccount;
import lk.jiat.app.core.service.UserAccountService;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashBoard extends HttpServlet {

    @EJB
    private UserAccountService userAccountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dasboard");

        try {

            List<UserAccount> userAccounts = userAccountService.getAllUserAccount();
            request.setAttribute("userAccounts", userAccounts);
            for (UserAccount account: userAccounts){
                System.out.println(account.getAccountNumber());
            }
            request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
