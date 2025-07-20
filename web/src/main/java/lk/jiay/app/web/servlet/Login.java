package lk.jiay.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.model.UserAccount;
import lk.jiat.app.core.service.UserAccountService;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @EJB
    private UserAccountService userAccountService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AuthenticationParameters parameters = AuthenticationParameters.withParams()
                .credential(new UsernamePasswordCredential(email, password));

        AuthenticationStatus status = securityContext.authenticate(request, response, parameters);
        if (status == AuthenticationStatus.SUCCESS){

            List<UserAccount> userAccounts = userAccountService.getAllUserAccount();
            request.setAttribute("userAccounts", userAccounts);
            response.sendRedirect(request.getContextPath()+"/dashboard");
        }else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}
