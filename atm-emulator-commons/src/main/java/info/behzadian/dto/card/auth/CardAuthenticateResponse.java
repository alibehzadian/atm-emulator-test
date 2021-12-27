package info.behzadian.dto.card.auth;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAuthenticateResponse {
    private Boolean result;
    private String reason;
}
