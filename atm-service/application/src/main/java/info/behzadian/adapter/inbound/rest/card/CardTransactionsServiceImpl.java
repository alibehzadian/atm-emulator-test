package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.transactions.CardTransactionsCommand;
import info.behzadian.dto.card.transactions.CardTransactionsResponse;
import info.behzadian.port.inbound.rest.CardTransactionsService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardTransactionsServiceImpl implements CardTransactionsService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardTransactionsResponse cardTransactions(CardTransactionsCommand command) {
        log.debug("CardTransactionsService.cardTransactions");
        log.debug("Command: {}", command);
        var result = bankServiceClient.transactions(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
