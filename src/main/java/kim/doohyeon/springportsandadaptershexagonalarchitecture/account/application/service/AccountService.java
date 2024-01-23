package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.service;

import jakarta.transaction.Transactional;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.request.SendMoneyRequest;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase.GetAccount;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase.OpenAccount;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase.SendMoney;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output.CreateAccountPort;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output.LoadAccountPort;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Money;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.TransactionHistory;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.common.custom_annotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.Random;

@UseCase
@Transactional
@RequiredArgsConstructor
public class AccountService implements OpenAccount, GetAccount, SendMoney {
    private final LoadAccountPort loadAccountPort;
    private final CreateAccountPort createAccountPort;

    @Override
    public Account openAccount(String memberName) {
        Account account = new Account(generateRandomNumberString(10), new Money(BigInteger.ZERO), memberName);
        return createAccountPort.createAccount(account);
    }

    private String generateRandomNumberString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

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
