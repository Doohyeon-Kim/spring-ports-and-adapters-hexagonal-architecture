package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model;

import lombok.Builder;
import lombok.NonNull;

import java.math.BigInteger;

@Builder
public record TransactionHistory(@NonNull String sourceAccountNumber, @NonNull String targetAccountNumber, @NonNull BigInteger amount){

}
