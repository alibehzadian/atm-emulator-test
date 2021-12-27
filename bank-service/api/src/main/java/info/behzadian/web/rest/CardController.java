package info.behzadian.web.rest;

import info.behzadian.dto.card.auth.CardAuthenticateCommand;
import info.behzadian.dto.card.auth.CardAuthenticateResponse;
import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;
import info.behzadian.dto.card.transactions.CardTransactionsCommand;
import info.behzadian.dto.card.transactions.CardTransactionsResponse;
import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;
import info.behzadian.port.inbound.rest.card.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/card")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final VerifyCardService verifyCardService;
    private final AuthenticateCardService authenticateCardService;
    private final CardBalanceService cardBalanceService;
    private final ChangeCardAuthMethodService changeCardAuthMethodService;
    private final CardTransactionsService cardTransactionsService;

    /**
     *
     * @param command
     * @return
     */
    @GetMapping("/verify")
    public ResponseEntity<CardVerificationResponse> verifyCard(CardVerificationCommand command) {
        log.debug("CardController.verifyCard");
        log.debug("Command: {}", command);
        var output = verifyCardService.verifyCard(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     *
     * @param command
     * @return
     */
    @GetMapping("/authenticate")
    public ResponseEntity<CardAuthenticateResponse> authenticateCard(CardAuthenticateCommand command) {
        log.debug("CardController.authenticateCard");
        log.debug("Command: {}", command);
        var output = authenticateCardService.authenticateCard(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     *
     * @param command
     * @return
     */
    @GetMapping("/balance")
    public ResponseEntity<CardBalanceResponse> balance(CardBalanceCommand command) {
        log.debug("CardController.balance");
        log.debug("Command: {}", command);
        var output = cardBalanceService.cardBalance(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     *
     * @param command
     * @return
     */
    @PutMapping("/change-auth-method")
    public ResponseEntity<CardChangeAuthenticationMethodResponse> changeAuthMethod(
            @RequestBody CardChangeAuthenticationMethodCommand command) {
        log.debug("CardController.changeAuthMethod");
        log.debug("Command: {}", command);
        var output = changeCardAuthMethodService.changeAuthMethod(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     *
     * @param command
     * @return
     */
    @GetMapping("/transactions")
    public ResponseEntity<CardTransactionsResponse> transactions(CardTransactionsCommand command) {
        log.debug("CardController.transactions");
        log.debug("Command: {}", command);
        var output = cardTransactionsService.cardTransactions(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

}
