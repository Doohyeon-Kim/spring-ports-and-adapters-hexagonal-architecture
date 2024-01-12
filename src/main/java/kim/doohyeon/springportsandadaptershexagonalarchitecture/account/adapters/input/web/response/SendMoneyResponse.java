package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.response;
import lombok.NonNull;

import java.math.BigInteger;

public record SendMoneyResponse(@NonNull String sourceAccountNumber, @NonNull String targetAccountNumber, @NonNull BigInteger amount) {

}

