package info.behzadian.adapter.outbound.persistence;

import info.behzadian.domain.CardTransaction;
import info.behzadian.persistence.repository.JpaCardTransactionRepository;
import info.behzadian.port.outbound.persistence.CardTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CardTransactionRepositoryImpl implements CardTransactionRepository {

    private final JpaCardTransactionRepository jpaCardTransactionRepository;

    @Override
    public List<CardTransaction> findTransactions(String cardNumber) {
        return jpaCardTransactionRepository.findAllByCardCardNumber(cardNumber);
    }

    @Override
    public List<CardTransaction> findTransactionsInTimeRange(String cardNumber, Instant from, Instant to) {
        return jpaCardTransactionRepository.findAllByInTimeRange(cardNumber, from, to);
    }

    @Override
    public CardTransaction save(CardTransaction transaction) {
        return jpaCardTransactionRepository.save(transaction);
    }
}
