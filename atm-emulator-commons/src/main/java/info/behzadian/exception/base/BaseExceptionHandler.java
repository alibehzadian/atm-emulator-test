package info.behzadian.exception.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        List<String> details = Collections.singletonList(ex.getLocalizedMessage());
        return createExceptionResponseEntity(details, "Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }   

    protected ResponseEntity<Object> createExceptionResponseEntity(final List<String> details,
                                                                  String message,
                                                                  HttpStatus httpStatus) {
       ApiError err = new ApiError(LocalDateTime.now(), httpStatus, message, details);
       return ResponseEntityBuilder.build(err);
   }
}
