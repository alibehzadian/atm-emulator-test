package info.behzadian.port.inbound.rest;

import info.behzadian.dto.card.balance.CardBalanceCommand;
import info.behzadian.dto.card.balance.CardBalanceResponse;

public interface CardBalanceService {
    CardBalanceResponse cardBalance(CardBalanceCommand command);
}
