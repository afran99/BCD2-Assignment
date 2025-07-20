package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.AccountType;
import lk.jiat.app.core.service.AccountTypeService;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/customerAccount.jsp")
public class UserAccounts  extends HttpServlet {
    @EJB
    private AccountTypeService accountTypeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
            request.setAttribute("accountTypes", accountTypes);
            request.getRequestDispatcher("/admin/customerAccount.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
