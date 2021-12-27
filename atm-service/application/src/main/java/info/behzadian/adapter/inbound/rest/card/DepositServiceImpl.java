package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.deposit.DepositCommand;
import info.behzadian.dto.transaction.CardTransactionResponse;
import info.behzadian.port.inbound.rest.DepositService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepositServiceImpl implements DepositService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardTransactionResponse deposit(DepositCommand command) {
        log.debug("DepositService.deposit");
        log.debug("Command: {}", command);
        var result = bankServiceClient.deposit(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
