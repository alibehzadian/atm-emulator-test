package info.behzadian.domain;

import info.behzadian.domain.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CardTransaction extends BaseEntity {

    /**
     * The Card that transaction belongs to
     */
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    /**
     * Amount of the transaction
     */
    @Column(precision = 21, scale = 9)
    private BigDecimal amount;

    /**
     * Card balance before the transaction
     */
    @Column(precision = 21, scale = 9)
    private BigDecimal beforeBalance;

    /**
     * Card balance after the transaction
     */
    @Column(precision = 21, scale = 9)
    private BigDecimal afterBalance;

    /**
     * Exact datetime of the transaction
     */
    @Column
    private Instant createDateTime;

    /**
     * Type of the transaction. one of DEPOSIT or WITHDRAWAL
     */
    @Column
    @Enumerated(EnumType.STRING)
    private CardTransactionType transactionType;
}
