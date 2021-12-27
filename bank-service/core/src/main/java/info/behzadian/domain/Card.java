package info.behzadian.domain;

import info.behzadian.domain.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity {

    /**
     * Remaining balance of the card
     */
    @Column(precision = 21, scale = 9)
    private BigDecimal balance;

    /**
     * Number of the card, printed on the card face
     */
    @Column
    private String cardNumber;

    /**
     * PIN of the card that owner uses to access card operations
     */
    @Column
    private String cardPin;

    /**
     * Fingerprint pattern of the card owner.
     * Only works if owner selects fingerprint for card authentication method
     */
    @Column
    private String fingerPrint;

    /**
     * Card auth. method. Default is PIN. Card owner can change it to fingerprint
     */
    @Column
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private CardAuthMethod authMethod = CardAuthMethod.PIN;
}
