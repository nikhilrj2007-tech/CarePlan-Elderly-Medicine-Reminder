package careplan.exception;
import careplan.exception.DuplicateDoseException;

public class DuplicateDoseException extends RuntimeException {

    public DuplicateDoseException(String message) {
        super(message);
    }
}
