package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;
import info.behzadian.port.inbound.rest.ChangeAuthenticationMethodService;
import info.behzadian.port.outbound.client.bankservice.BankServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChangeAuthenticationMethodServiceImpl implements ChangeAuthenticationMethodService {

    private final BankServiceClient bankServiceClient;

    /**
     *
     * @param command
     * @return
     */
    @Override
    public CardChangeAuthenticationMethodResponse changeAuthMethod(CardChangeAuthenticationMethodCommand command) {
        log.debug("ChangeAuthenticationMethodService.changeAuthMethod");
        log.debug("Command: {}", command);
        var result = bankServiceClient.changeAuthMethod(command).getBody();
        log.debug("result: {}", result);
        return result;
    }
}
