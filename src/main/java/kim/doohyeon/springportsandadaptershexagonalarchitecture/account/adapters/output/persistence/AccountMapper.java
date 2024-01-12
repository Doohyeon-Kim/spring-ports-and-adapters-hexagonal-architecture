package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Money;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    Account mapToDomainModel(AccountEntity accountEntity) {
        return Account.of(accountEntity.getAccountNumber(), Money.of(accountEntity.getBalance()), accountEntity.getName());
    }
}

