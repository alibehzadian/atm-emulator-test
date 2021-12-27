package info.behzadian.dto.card.auth;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAuthenticateCommand {
    private String cardNumber;
    private String authMethod;
    private String authValue;
}
