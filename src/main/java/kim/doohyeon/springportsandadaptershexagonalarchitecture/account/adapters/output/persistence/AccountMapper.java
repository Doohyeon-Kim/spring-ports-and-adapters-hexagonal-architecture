package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Money;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    Account toModel(AccountEntity accountEntity) {
        return Account.of(accountEntity.getAccountNumber(), Money.of(accountEntity.getBalance()), accountEntity.getMemberName());
    }

    AccountEntity toEntity(Account account) {
        return AccountEntity.builder().accountNumber(account.accountNumber()).balance(account.balance().amount()).memberName(account.memberName()).build();
    }
}

