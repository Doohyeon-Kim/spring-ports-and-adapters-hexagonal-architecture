package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.output.persistence;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;

@Entity
@Table(name = "ACCOUNT")
@Getter
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String accountNumber;
    @NonNull
    private BigInteger balance;
    @NonNull
    private String memberName;

    @Builder
    public AccountEntity(String accountNumber, BigInteger balance, String memberName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.memberName = memberName;
    }
}
