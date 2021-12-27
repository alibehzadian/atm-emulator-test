package info.behzadian.dto.card.transactions;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardTransactionsCommand {
    private String cardNumber;
    private Instant from;
    private Instant to;
}
