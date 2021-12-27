package info.behzadian.port.inbound.rest.card;

import info.behzadian.dto.card.auth.CardAuthenticateCommand;
import info.behzadian.dto.card.auth.CardAuthenticateResponse;

public interface AuthenticateCardService {

    CardAuthenticateResponse authenticateCard(CardAuthenticateCommand command);
}
