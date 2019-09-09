//A-Exceptions

import java.util.InputMismatchException;

/**
 * DukeException class that extends InputMismatchException
 * It is to send the error message to the user when the input is in the wrong format
 */
public class DukeException extends InputMismatchException{
    /**
     * Constructs the Class that returns a error message to the user when input is invalid
     *
     * @param message String error message
     */
    public DukeException(String message) {
        super(message);
    }
}
