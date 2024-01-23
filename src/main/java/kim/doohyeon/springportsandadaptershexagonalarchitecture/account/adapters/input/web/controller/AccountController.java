package kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.controller;

import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.mapper.ResponseMapper;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.request.AccountOpenRequest;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.request.SendMoneyRequest;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.response.GetAccountResponse;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.adapters.input.web.response.SendMoneyResponse;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.ports.input.usecase.SendMoney;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.application.service.AccountService;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.Account;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.account.domain.model.TransactionHistory;
import kim.doohyeon.springportsandadaptershexagonalarchitecture.common.custom_annotations.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
class AccountController {
    private final AccountService accountService;

    @PostMapping(path = "/open")
    ResponseEntity<GetAccountResponse> openBankAccount(@RequestBody AccountOpenRequest accountOpenRequest) throws Exception {
        Account account = accountService.openAccount(accountOpenRequest.getMemberName());
        System.out.println(accountOpenRequest);
        return ResponseMapper.mapToGetAccountResponse(account);
    }
    @GetMapping("/{accountNumber}")
    ResponseEntity<GetAccountResponse> getAccount(@PathVariable("accountNumber") String accountNumber) throws Exception {
        Account account = accountService.getAccount(accountNumber);
        System.out.println(account);
        System.out.println(account.accountNumber());
        return ResponseMapper.mapToGetAccountResponse(account);
    }
    @PostMapping(path = "/send-money")
    ResponseEntity<SendMoneyResponse> sendMoney(@RequestBody SendMoneyRequest sendMoneyRequest) throws Exception {
        TransactionHistory transactionHistory = accountService.sendMoney(sendMoneyRequest.getSourceAccountNumber(), sendMoneyRequest.getTargetAccountNumber(), sendMoneyRequest.getAmount());
        System.out.println(transactionHistory);
        return ResponseMapper.mapToSendMoneyResponse(transactionHistory);
    }
}
