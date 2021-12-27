package info.behzadian.dto.card.verify;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardVerificationCommand {
    private String cardNumber;
}
