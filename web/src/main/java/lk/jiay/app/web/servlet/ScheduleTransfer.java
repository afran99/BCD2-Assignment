package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.Frequency;
import lk.jiat.app.core.model.UserAccount;
import lk.jiat.app.core.service.FrequencyService;
import lk.jiat.app.core.service.UserAccountService;

import java.io.IOException;
import java.util.List;

@WebServlet("/scheduleTransfer")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"ADMIN"}))
public class ScheduleTransfer extends HttpServlet {

    @EJB
    private UserAccountService userAccountService;

    @EJB
    private FrequencyService frequencyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("shedulaccount");

        try {
            List<UserAccount> userAccounts = userAccountService.getAllUserAccount();
            List<Frequency> frequencies = frequencyService.getAllFrequencies();

            request.setAttribute("userAccounts", userAccounts);
            request.setAttribute("frequencies", frequencies);
            request.getRequestDispatcher("/admin/scheduledTransfers.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
