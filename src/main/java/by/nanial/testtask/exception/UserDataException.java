package by.nanial.testtask.exception;

public class UserDataException extends Exception {
    public UserDataException() {
    }

    public UserDataException(String message) {
        super(message);
    }

    public UserDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDataException(Throwable cause) {
        super(cause);
    }

}
