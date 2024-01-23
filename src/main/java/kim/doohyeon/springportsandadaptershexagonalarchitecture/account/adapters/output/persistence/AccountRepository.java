package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;

import jakarta.persistence.EntityListeners;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@EntityListeners(AuditingEntityListener.class)
@Repository
interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}

