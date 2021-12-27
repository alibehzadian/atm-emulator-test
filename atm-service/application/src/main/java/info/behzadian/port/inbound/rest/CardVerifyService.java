package info.behzadian.port.inbound.rest;

import info.behzadian.dto.card.verify.CardVerificationCommand;
import info.behzadian.dto.card.verify.CardVerificationResponse;

public interface CardVerifyService {
    CardVerificationResponse verifyCard(CardVerificationCommand command);
}
