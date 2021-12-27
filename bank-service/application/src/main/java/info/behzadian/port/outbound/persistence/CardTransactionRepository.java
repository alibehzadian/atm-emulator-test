package info.behzadian.port.outbound.persistence;

import info.behzadian.domain.CardTransaction;
import info.behzadian.domain.CardTransactionType;

import java.time.Instant;
import java.util.List;

public interface CardTransactionRepository {

    List<CardTransaction> findTransactions(String cardNumber);

    List<CardTransaction> findTransactionsInTimeRange(String cardNumber, Instant from, Instant to);

    CardTransaction save(CardTransaction transaction);

}
