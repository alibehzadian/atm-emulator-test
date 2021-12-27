package info.behzadian.dto.card.balance;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardBalanceCommand {
    private String cardNumber;
}
