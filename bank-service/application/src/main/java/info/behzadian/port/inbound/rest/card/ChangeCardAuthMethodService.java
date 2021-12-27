package info.behzadian.port.inbound.rest.card;

import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;

public interface ChangeCardAuthMethodService {

    CardChangeAuthenticationMethodResponse changeAuthMethod(CardChangeAuthenticationMethodCommand command);
}
