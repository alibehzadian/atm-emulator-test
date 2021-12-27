package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;
import info.behzadian.port.inbound.rest.CardVerifyService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardVerifyServiceImpl implements CardVerifyService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardVerificationResponse verifyCard(CardVerificationCommand command) {
        log.debug("CardVerifyService.verifyCard");
        log.debug("Command: {}", command);
        var result = bankServiceClient.verifyCard(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
