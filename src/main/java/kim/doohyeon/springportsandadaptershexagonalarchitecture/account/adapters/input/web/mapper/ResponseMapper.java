package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.mapper;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.response.GetAccountResponse;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.response.SendMoneyResponse;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.TransactionHistory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {
    static public ResponseEntity<GetAccountResponse> mapToGetAccountResponse(Account account) {
        GetAccountResponse getAccountResponse = new GetAccountResponse(account.accountNumber(), account.balance(), account.memberName());
        return new ResponseEntity<>(getAccountResponse, HttpStatus.OK);
    }

    static public ResponseEntity<SendMoneyResponse> mapToSendMoneyResponse(TransactionHistory transactionHistory) {
        SendMoneyResponse sendMoneyResponse = new SendMoneyResponse(transactionHistory.sourceAccountNumber(), transactionHistory.targetAccountNumber(), transactionHistory.amount());
        return new ResponseEntity<>(sendMoneyResponse, HttpStatus.OK);
    }

}
