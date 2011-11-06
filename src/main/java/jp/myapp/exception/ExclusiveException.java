package jp.myapp.exception;

public class ExclusiveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExclusiveException() {
        super();
    }

    public ExclusiveException(String message) {
        super(message);
    }

    public ExclusiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExclusiveException(Throwable cause) {
        super(cause);
    }
}
