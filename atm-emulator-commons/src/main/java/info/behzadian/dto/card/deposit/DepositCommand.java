package info.behzadian.dto.card.deposit;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositCommand {
    private String cardNumber;
    private BigDecimal amount;
}
