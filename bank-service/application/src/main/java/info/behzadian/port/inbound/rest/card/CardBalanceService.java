package info.behzadian.port.inbound.rest.card;

import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;

public interface CardBalanceService {

    CardBalanceResponse cardBalance(CardBalanceCommand command);

}
