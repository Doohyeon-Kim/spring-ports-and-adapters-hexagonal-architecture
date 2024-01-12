package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model;

import lombok.Builder;
import lombok.NonNull;

import java.math.BigInteger;

@Builder
public record Money(@NonNull BigInteger amount) {
    public static Money ZERO = Money.of(BigInteger.ZERO);

    public boolean isPositiveOrZero() {
        return this.amount.compareTo(BigInteger.ZERO) >= 0;
    }

    public boolean isNegative() {
        return this.amount.compareTo(BigInteger.ZERO) < 0;
    }

    public boolean isPositive() {
        return this.amount.compareTo(BigInteger.ZERO) > 0;
    }

    public boolean isGreaterThanOrEqualTo(Money money) {
        return this.amount.compareTo(money.amount) >= 0;
    }

    public boolean isGreaterThan(Money money) {
        return this.amount.compareTo(money.amount) >= 1;
    }

    public static Money of(BigInteger value) {
        return Money.builder().amount(value).build();
    }

    public Money plus(@NonNull BigInteger amount) {
        return new Money(this.amount.add(amount));
    }

    public Money minus(@NonNull BigInteger amount) {
        return new Money(this.amount.subtract(amount));
    }
}
