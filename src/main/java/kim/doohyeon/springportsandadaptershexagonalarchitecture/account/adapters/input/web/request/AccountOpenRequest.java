package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.request;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigInteger;

@Getter
public class AccountOpenRequest {
    @NonNull
    private String memberName;
}

