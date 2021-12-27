package info.behzadian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CardAuthenticationTrialExceededException extends RuntimeException {

    public CardAuthenticationTrialExceededException() {
        this("You entered card auth wrong 3 times. your card is blocked.");
    }

    public CardAuthenticationTrialExceededException(String message) {
        super(message);
    }
}
