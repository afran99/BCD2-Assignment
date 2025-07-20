package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.service.FrequencyService;
import lk.jiat.app.core.service.NewScheduleTransferService;
import lk.jiat.app.core.service.UserAccountService;

import java.io.IOException;

@ServletSecurity(@HttpConstraint(rolesAllowed = {"ADMIN"}))
@WebServlet("/newST")
public class NewScheduleTransfer extends HttpServlet {

    @EJB
    private NewScheduleTransferService newScheduleTransferService;

    @EJB
    private FrequencyService frequencyService;

    @EJB
    private UserAccountService userAccountService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("newst");

        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        String amount = request.getParameter("amount");
        String tDate = request.getParameter("transferTime");


    }
}
