package info.behzadian.dto.card.changeauth;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardChangeAuthenticationMethodCommand {
    private String cardNumber;
    private String currentAuthValue;
    private String newAuthMethod;
    private String newAuthValue;
}
