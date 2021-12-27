package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.auth.CardAuthenticateCommand;
import info.behzadian.dto.card.auth.CardAuthenticateResponse;
import info.behzadian.port.inbound.rest.AuthenticateCardService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticateCardServiceImpl implements AuthenticateCardService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardAuthenticateResponse authenticateCard(CardAuthenticateCommand command) {
        log.debug("AuthenticateCardService.authenticateCard");
        log.debug("Command: {}", command);
        var result = bankServiceClient.authenticateCard(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
