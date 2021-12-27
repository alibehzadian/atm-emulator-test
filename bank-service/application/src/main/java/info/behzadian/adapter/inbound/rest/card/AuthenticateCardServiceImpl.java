package info.behzadian.adapter.inbound.rest.card;

import info.behzadian.domain.Card;
import info.behzadian.domain.CardAuthMethod;
import info.behzadian.dto.card.auth.CardAuthenticateCommand;
import info.behzadian.dto.card.auth.CardAuthenticateResponse;
import info.behzadian.exception.CardNotFountException;
import info.behzadian.port.inbound.rest.card.AuthenticateCardService;
import info.behzadian.port.outbound.persistence.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticateCardServiceImpl implements AuthenticateCardService {

    private final CardRepository cardRepository;

    @Override
    @Transactional(readOnly = true)
    public CardAuthenticateResponse authenticateCard(CardAuthenticateCommand command) {
        log.debug("AuthenticateCardService.authenticateCard");
        log.debug("Command: {}", command);

        log.debug("check if card exists");
        Card card = cardRepository.findByCardNumber(command.getCardNumber())
                .orElseThrow(CardNotFountException::new);
        log.debug("Card: {}", card);

        CardAuthenticateResponse response = CardAuthenticateResponse.builder().result(true).build();

        switch (CardAuthMethod.valueOf(command.getAuthMethod())) {
            case PIN:
                log.debug("card auth method is PIN");
                if(!command.getAuthValue().equals(card.getCardPin())) {
                    log.debug("invalid PIN entered");
                    response.setResult(false);
                    response.setReason("Invalid PIN");
                }
                break;
            case FINGER_PRINT:
                log.debug("card auth method is FINGERPRINT");
                if(!command.getAuthValue().equals(card.getFingerPrint())) {
                    log.debug("invalid FINGERPRINT entered");
                    response.setResult(false);
                    response.setReason("Invalid Fingerprint");
                }
                break;
        }

        log.debug("Response: {}", response);
        return response;
    }
}
