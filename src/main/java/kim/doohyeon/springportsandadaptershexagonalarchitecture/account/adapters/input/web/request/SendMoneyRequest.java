package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.request;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigInteger;


@Getter
public class SendMoneyRequest {
    @NonNull
    String sourceAccountNumber;
    @NonNull
    String targetAccountNumber;
    @NonNull
    BigInteger amount;
}
