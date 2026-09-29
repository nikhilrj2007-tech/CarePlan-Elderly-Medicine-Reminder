package careplan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateDoseException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDuplicateDose(
            DuplicateDoseException exception) {
        return exception.getMessage();
    }
}
