package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AccountRepository extends JpaRepository<AccountEntity, String> {
}

