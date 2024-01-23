package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;


import jakarta.persistence.EntityNotFoundException;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output.CreateAccountPort;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output.LoadAccountPort;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.common.custom_annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class AccountPersistenceAdapter implements CreateAccountPort, LoadAccountPort {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account createAccount(Account account) {
        System.out.println(account);
        AccountEntity savedAccountEntity = accountRepository.save(accountMapper.toEntity(account));
        return loadAccount(savedAccountEntity.getAccountNumber());
    }

    @Override
    public Account loadAccount(String accountNumber) {
        System.out.println(accountRepository.findAll());
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber).orElseThrow(EntityNotFoundException::new);
        return accountMapper.toModel(accountEntity);
    }
}
