package info.behzadian.dto.card.transactions;

import info.behzadian.dto.transaction.CardTransactionResponse;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardTransactionsResponse {
    private Instant from;
    private Instant to;
    private Integer transactionsCount;
    private List<CardTransactionResponse> transactions;
}
