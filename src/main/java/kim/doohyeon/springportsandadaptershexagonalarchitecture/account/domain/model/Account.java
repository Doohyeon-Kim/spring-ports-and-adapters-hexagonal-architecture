package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model;


import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.Optional;


@Builder
public record Account(@NonNull String accountNumber, Money balance, String name) {
    public TransactionHistory transfer(@NonNull Account targetAccount, @NonNull BigInteger amount) throws Exception {
        if (balance.amount().compareTo(amount) >= 0) {
            balance.minus(amount);
            targetAccount.balance.plus(amount);
            return TransactionHistory.builder().sourceAccountNumber(this.accountNumber).
                    targetAccountNumber(targetAccount.accountNumber).
                    amount(balance.amount()).build();
        } else {
            throw new Exception("Insufficient balance to transfer");
        }
    }

    public Money deposit(@NonNull BigInteger amount) {
        return balance.plus(amount);
    }

    public Money withdraw(@NonNull BigInteger amount) throws Exception {
        if (balance.amount().compareTo(amount) >= 0) {
            return balance.minus(amount);
        } else {
            throw new Exception("Insufficient balance for withdrawal");
        }
    }

    public static Account of(String accountNumber, Money balance, String name) {
        return Account.builder().accountNumber(accountNumber).balance(balance).name(name).build();
    }
}
