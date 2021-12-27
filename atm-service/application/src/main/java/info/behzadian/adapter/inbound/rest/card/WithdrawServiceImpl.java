package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.withdraw.WithdrawCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import info.behzadian.port.inbound.rest.WithdrawService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WithdrawServiceImpl implements WithdrawService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardTransactionResponse withdraw(WithdrawCommand command) {
        log.debug("WithdrawService.withdraw");
        log.debug("Command: {}", command);
        var result = bankServiceClient.withdraw(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
