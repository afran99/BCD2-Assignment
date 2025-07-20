package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.SIngleTransaction;
import lk.jiat.app.core.service.FrequencyService;
import lk.jiat.app.core.service.NewScheduleTransferService;
import lk.jiat.app.core.service.SingleTransactionSession;
import lk.jiat.app.core.service.UserAccountService;

import java.io.IOException;
import java.util.Date;

@ServletSecurity(@HttpConstraint(rolesAllowed = {"ADMIN"}))
@WebServlet("/newST")
public class NewScheduleTransfer extends HttpServlet {

    @EJB
    private NewScheduleTransferService newScheduleTransferService;

    @EJB
    private FrequencyService frequencyService;

    @EJB
    private UserAccountService userAccountService;

    @EJB
    private SingleTransactionSession singleTransactionSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("newst");

        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        String amount = request.getParameter("amount");

        String frequency = request.getParameter("frequency");
        String description = request.getParameter("description");
        Date date = new Date();

        if (frequency.equals("1")){

            SIngleTransaction sIngleTransaction = new SIngleTransaction();
            sIngleTransaction.setFromAccount(fromAccount);
            sIngleTransaction.setToAccount(toAccount);
            sIngleTransaction.setAmount(Double.parseDouble(amount));
            sIngleTransaction.setTransferTime(date);
            sIngleTransaction.setDescription(description);

            singleTransactionSession.addTranasaction(sIngleTransaction);
        }

        lk.jiat.app.core.model.NewScheduleTransfer newScheduleTransfer = new lk.jiat.app.core.model.NewScheduleTransfer();
        newScheduleTransfer.setFrequency(frequency);
        newScheduleTransfer.setFromAccount(fromAccount);
        newScheduleTransfer.setToAccount(toAccount);
        newScheduleTransfer.setAmount(Double.parseDouble(amount));
        newScheduleTransfer.setTransferTime(date);
        newScheduleTransfer.setDescription(description);







    }
}
