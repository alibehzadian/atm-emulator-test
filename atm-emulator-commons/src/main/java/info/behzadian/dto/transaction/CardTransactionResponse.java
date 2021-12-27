package info.behzadian.dto.transaction;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardTransactionResponse {
    private String cardNumber;
    private BigDecimal amount;
    private Instant createDateTime;
    private String transactionType;
}
