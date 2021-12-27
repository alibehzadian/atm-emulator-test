package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;
import info.behzadian.port.inbound.rest.CardBalanceService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardBalanceServiceImpl implements CardBalanceService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardBalanceResponse cardBalance(CardBalanceCommand command) {
        log.debug("CardBalanceService.cardBalance");
        log.debug("Command: {}", command);
        var result = bankServiceClient.balance(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
