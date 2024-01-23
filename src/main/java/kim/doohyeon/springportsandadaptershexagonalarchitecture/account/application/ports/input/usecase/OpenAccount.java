package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;

public interface OpenAccount {
    Account openAccount(String memberName);
}