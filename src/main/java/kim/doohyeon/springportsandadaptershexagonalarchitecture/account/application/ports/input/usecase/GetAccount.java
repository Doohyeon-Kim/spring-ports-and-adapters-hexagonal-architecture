package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;

public interface GetAccount {
    Account getAccount(String accountNumber);
}
