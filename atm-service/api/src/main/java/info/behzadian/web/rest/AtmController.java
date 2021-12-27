package info.behzadian.web.rest;

import info.behzadian.dto.card.auth.CardAuthenticateCommand;
import info.behzadian.dto.card.auth.CardAuthenticateResponse;
import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;
import info.behzadian.dto.card.deposit.DepositCommand;
import info.behzadian.dto.card.transactions.CardTransactionsCommand;
import info.behzadian.dto.card.transactions.CardTransactionsResponse;
import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;
import info.behzadian.dto.card.withdraw.WithdrawCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import info.behzadian.exception.CardAuthenticationTrialExceededException;
import info.behzadian.port.inbound.rest.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v1/atm-service")
@RequiredArgsConstructor
@Slf4j
public class AtmController {

    private final CardVerifyService cardVerifyService;
    private final AuthenticateCardService authenticateCardService;
    private final CardBalanceService cardBalanceService;
    private final ChangeAuthenticationMethodService changeAuthenticationMethodService;
    private final CardTransactionsService cardTransactionsService;
    private final DepositService depositService;
    private final WithdrawService withdrawService;

    /**
     * @param command
     * @return
     */
    @GetMapping("/insert-card")
    public ResponseEntity<CardVerificationResponse> insertCard(CardVerificationCommand command) {
        log.debug("AtmController.insertCard");
        log.debug("Command: {}", command);
        var output = cardVerifyService.verifyCard(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @param command
     * @return
     */
    @GetMapping("/auth-card")
    public ResponseEntity<CardAuthenticateResponse> authenticateCard(CardAuthenticateCommand command, HttpSession session) {
        log.debug("AtmController.authenticateCard");
        log.debug("Command: {}", command);

        Integer requestCount = (Integer) session.getAttribute("requestCount");
        requestCount = requestCount != null ? requestCount : 0;
        requestCount++;
        session.setAttribute("requestCount", requestCount);
        if (requestCount >= 3) {
            throw new CardAuthenticationTrialExceededException();
        }

        var output = authenticateCardService.authenticateCard(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @param command
     * @return
     */
    @GetMapping("/command/get-balance")
    public ResponseEntity<CardBalanceResponse> balance(CardBalanceCommand command) {
        log.debug("AtmController.balance");
        log.debug("Command: {}", command);
        var output = cardBalanceService.cardBalance(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @param command
     * @return
     */
    @PutMapping("/command/change-auth-method")
    public ResponseEntity<CardChangeAuthenticationMethodResponse> changeAuthMethod(@RequestBody CardChangeAuthenticationMethodCommand command) {
        log.debug("AtmController.changeAuthMethod");
        log.debug("Command: {}", command);
        var output = changeAuthenticationMethodService.changeAuthMethod(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @param command
     * @return
     */
    @GetMapping("/command/get-transactions")
    public ResponseEntity<CardTransactionsResponse> cardTransactions(CardTransactionsCommand command) {
        log.debug("AtmController.cardTransactions");
        log.debug("Command: {}", command);
        var output = cardTransactionsService.cardTransactions(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @param command
     * @return
     */
    @PostMapping("/command/deposit")
    public ResponseEntity<CardTransactionResponse> deposit(@RequestBody DepositCommand command) {
        log.debug("AtmController.deposit");
        log.debug("Command: {}", command);
        var output = depositService.deposit(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @param command
     * @return
     */
    @PostMapping("/command/withdraw")
    public ResponseEntity<CardTransactionResponse> withdraw(@RequestBody WithdrawCommand command) {
        log.debug("AtmController.withdraw");
        log.debug("Command: {}", command);
        var output = withdrawService.withdraw(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     * @return
     */
    @GetMapping("/exit-card")
    public ResponseEntity<Void> exitCard() {
        log.debug("AtmController.exitCard");
        return ResponseEntity.ok().build();
    }
}
