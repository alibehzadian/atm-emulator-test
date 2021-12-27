package info.behzadian.port.inbound.rest;

import info.behzadian.dto.card.transactions.CardTransactionsCommand;
import info.behzadian.dto.card.transactions.CardTransactionsResponse;

public interface CardTransactionsService {
    CardTransactionsResponse cardTransactions(CardTransactionsCommand command);
}
