package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.service;

import jakarta.transaction.Transactional;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.request.SendMoneyRequest;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase.GetAccount;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase.SendMoney;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output.LoadAccountPort;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.TransactionHistory;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.common.custom_annotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@UseCase
@Transactional
@RequiredArgsConstructor
public class AccountService implements GetAccount, SendMoney {
    private final LoadAccountPort loadAccountPort;


    @Override
    public Account getAccount(String accountNumber) {
        return loadAccountPort.loadAccount(accountNumber);
    }

    @Override
    public TransactionHistory sendMoney(String sourceAccountNumber, String targetAccountNumber, BigInteger amount) throws Exception {
        Account sourceAccount = loadAccountPort.loadAccount(sourceAccountNumber);
        Account targetAccount = loadAccountPort.loadAccount(targetAccountNumber);
        return sourceAccount.transfer(targetAccount, amount);
    }
}
