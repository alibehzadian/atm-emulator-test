package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.domain.Card;
import info.behzadian.domain.CardAuthMethod;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.port.inbound.rest.card.ChangeCardAuthMethodService;
import info.behzadian.port.outbound.persistence.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChangeCardAuthMethodServiceImpl implements ChangeCardAuthMethodService {

    private final CardRepository cardRepository;

    @Override
    public CardChangeAuthenticationMethodResponse changeAuthMethod(CardChangeAuthenticationMethodCommand command) {
        log.debug("ChangeCardAuthMethodService.changeAuthMethod");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        CardChangeAuthenticationMethodResponse response = CardChangeAuthenticationMethodResponse.builder()
                .result(true)
                .build();

        switch (card.getAuthMethod()) {
            case PIN:
                log.debug("card auth method is PIN");
                if(!command.getCurrentAuthValue().equals(card.getCardPin())) {
                    log.debug("Invalid PIN entered");
                    response.setResult(false);
                    response.setReason("Invalid PIN");
                } else {
                    card.setAuthMethod(CardAuthMethod.valueOf(command.getNewAuthMethod()));
                    card.setFingerPrint(command.getNewAuthValue());
                    cardRepository.save(card);
                    log.debug("Card auth method changed to FINGERPRINT");
                }
                break;
            case FINGER_PRINT:
                log.debug("card auth method is FINGERPRINT");
                if(!command.getCurrentAuthValue().equals(card.getFingerPrint())) {
                    log.debug("Invalid FINGERPRINT entered");
                    response.setResult(false);
                    response.setReason("Invalid Fingerprint");
                } else {
                    card.setAuthMethod(CardAuthMethod.valueOf(command.getNewAuthMethod()));
                    card.setFingerPrint(command.getNewAuthValue());
                    cardRepository.save(card);
                    log.debug("Card auth method changed to PIN");
                }
                break;
        }

        log.debug("Result: {}", response);
        return response;
    }
}
