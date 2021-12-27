package info.behzadian.port.inbound.rest;

import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodCommand;
import info.behzadian.dto.card.changeauth.CardChangeAuthenticationMethodResponse;

public interface ChangeAuthenticationMethodService {
    CardChangeAuthenticationMethodResponse changeAuthMethod(CardChangeAuthenticationMethodCommand command);
}
