package info.behzadian.adapter.outbound.persistence;

import info.behzadian.domain.Card;
import info.behzadian.persistence.repository.JpaCardRepository;
import info.behzadian.port.outbound.persistence.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final JpaCardRepository jpaCardRepository;

    @Override
    public Optional<Card> findByCardNumber(String cardNumber) {
        return jpaCardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Card save(Card card) {
        return jpaCardRepository.save(card);
    }
}
