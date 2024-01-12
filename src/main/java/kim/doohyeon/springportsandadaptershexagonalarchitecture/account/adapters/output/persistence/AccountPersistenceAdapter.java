package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;


import jakarta.persistence.EntityNotFoundException;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.output.LoadAccountPort;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.common.custom_annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(String accountNumber) {
        System.out.println(accountRepository.findAll());
        AccountEntity accountEntity = accountRepository.findById(accountNumber).orElseThrow(EntityNotFoundException::new);
        return accountMapper.mapToDomainModel(accountEntity);
    }
}
