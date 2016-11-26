package iwm2016.telemd.infrastructure.entity;

import iwm2016.telemd.infrastructure.datetime.DateProvider;
import iwm2016.telemd.users.UserProvider;
import org.springframework.stereotype.Component;

/**
 * @author kaminsj7
 */
@Component
public class SignatureProvider {

    private UserProvider userProvider;

    private DateProvider dateProvider;

    public SignatureProvider(UserProvider userProvider, DateProvider dateProvider) {
        this.userProvider = userProvider;
        this.dateProvider = dateProvider;
    }

    public Signature getCurrentUserSignature() {
        return Signature.createSignature(userProvider, dateProvider);
    }
}
