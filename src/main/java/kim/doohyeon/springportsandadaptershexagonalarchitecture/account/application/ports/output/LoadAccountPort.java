package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output;


import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;

public interface LoadAccountPort {
    Account loadAccount(String accountNumber);
}
