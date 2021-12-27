package info.behzadian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardNotFountException extends RuntimeException {

    public CardNotFountException() {
        this("Card not found");
    }

    public CardNotFountException(String message) {
        super(message);
    }
}
