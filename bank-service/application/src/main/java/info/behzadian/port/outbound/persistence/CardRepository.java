package info.behzadian.port.outbound.persistence;

import info.behzadian.domain.Card;

import java.util.Optional;

public interface CardRepository {

    Optional<Card> findByCardNumber(String cardNumber);

    Card save(Card card);

}
