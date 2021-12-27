package info.behzadian.web.rest;

import info.behzadian.dto.card.deposit.DepositCommand;
import info.behzadian.dto.card.withdraw.WithdrawCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import info.behzadian.port.inbound.rest.transaction.DepositService;
import info.behzadian.port.inbound.rest.transaction.WithdrawService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transaction")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final DepositService depositService;
    private final WithdrawService withdrawService;

    /**
     *
     * @param command
     * @return
     */
    @PostMapping("/deposit")
    public ResponseEntity<CardTransactionResponse> deposit(@RequestBody DepositCommand command) {
        log.debug("TransactionController.deposit");
        log.debug("Command: {}", command);
        var output = depositService.deposit(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }

    /**
     *
     * @param command
     * @return
     */
    @PostMapping("/withdraw")
    public ResponseEntity<CardTransactionResponse> withdraw(@RequestBody WithdrawCommand command) {
        log.debug("TransactionController.withdraw");
        log.debug("Command: {}", command);
        var output = withdrawService.withdraw(command);
        log.debug("Output: {}", output);
        return ResponseEntity.ok(output);
    }


}
