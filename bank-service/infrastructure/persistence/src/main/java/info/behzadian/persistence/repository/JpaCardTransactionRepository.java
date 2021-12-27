package info.behzadian.persistence.repository;

import info.behzadian.domain.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface JpaCardTransactionRepository extends JpaRepository<CardTransaction, Long> {

    List<CardTransaction> findAllByCardCardNumber(String cardNumber);

    @Query("select t from CardTransaction t where t.card.cardNumber = ?1 and t.createDateTime > ?2 and t.createDateTime < ?3")
    List<CardTransaction> findAllByInTimeRange(String cardNumber, Instant from, Instant to);

}
