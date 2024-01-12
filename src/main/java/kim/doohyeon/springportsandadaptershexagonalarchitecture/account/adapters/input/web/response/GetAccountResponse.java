package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.response;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Money;
import lombok.Builder;
import lombok.NonNull;

import java.math.BigInteger;

public record GetAccountResponse(@NonNull String accountNumber, Money balance, String name) {

}
