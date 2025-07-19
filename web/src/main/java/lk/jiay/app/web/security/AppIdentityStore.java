package lk.jiay.app.web.security;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import lk.jiat.app.core.model.User;
import lk.jiat.app.core.service.UserServise;

import java.util.Set;

@ApplicationScoped
public class AppIdentityStore implements IdentityStore {

    @EJB
    private UserServise userServise;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential){
            UsernamePasswordCredential upc = (UsernamePasswordCredential)credential;

            if (userServise.validate(upc.getCaller(), upc.getPasswordAsString())){
                User user = userServise.getUserByEmail(upc.getCaller());

                return new CredentialValidationResult(user.getEmail(), Set.of(user.getUserType().name()));
            }

        }

        return CredentialValidationResult.INVALID_RESULT;

    }
}
