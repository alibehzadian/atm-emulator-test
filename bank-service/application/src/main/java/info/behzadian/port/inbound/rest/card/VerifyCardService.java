package info.behzadian.port.inbound.rest.card;

import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;

public interface VerifyCardService {

    CardVerificationResponse verifyCard(CardVerificationCommand command);
}
