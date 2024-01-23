package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;

public interface CreateAccountPort {
    Account createAccount(Account account);
}
