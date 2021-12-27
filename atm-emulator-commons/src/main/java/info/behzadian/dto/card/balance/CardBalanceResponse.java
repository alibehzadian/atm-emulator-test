package info.behzadian.dto.card.balance;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardBalanceResponse {
    private String CardNumber;
    private BigDecimal balance;
}
