package iwm2016.telemd.infrastructure.entity;

import iwm2016.telemd.infrastructure.datetime.DateProvider;
import iwm2016.telemd.users.UserProvider;
import org.springframework.stereotype.Component;

/**
 * @author kaminsj7
 */
@Component
class SignatureProviderImpl implements SignatureProvider {

    private UserProvider userProvider;

    private DateProvider dateProvider;

    public SignatureProviderImpl(UserProvider userProvider, DateProvider dateProvider) {
        this.userProvider = userProvider;
        this.dateProvider = dateProvider;
    }

    @Override
    public Signature getCurrentUserSignature() {
        return Signature.createSignature(userProvider, dateProvider);
    }
}
