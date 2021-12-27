package info.behzadian.dto.card.withdraw;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawCommand {
    private String cardNumber;
    private BigDecimal amount;
}
