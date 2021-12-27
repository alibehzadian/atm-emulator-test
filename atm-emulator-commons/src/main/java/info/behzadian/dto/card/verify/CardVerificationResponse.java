package info.behzadian.dto.card.verify;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardVerificationResponse {
    private String cardNumber;
    private String authMethod;
}
