package info.behzadian.dto.card.changeauth;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardChangeAuthenticationMethodResponse {
    private Boolean result;
    private String reason;
}
