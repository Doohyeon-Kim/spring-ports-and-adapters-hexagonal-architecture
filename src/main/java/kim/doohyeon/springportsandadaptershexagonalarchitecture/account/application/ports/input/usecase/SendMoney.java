package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.TransactionHistory;

import java.math.BigInteger;

public interface SendMoney {
    TransactionHistory sendMoney(String sourceAccountNumber, String targetAccountNumber, BigInteger amount) throws Exception;
}