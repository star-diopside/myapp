package jp.myapp.exception;

public class NoRollbackApplicationException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public NoRollbackApplicationException() {
        super();
    }

    public NoRollbackApplicationException(String message) {
        super(message);
    }

    public NoRollbackApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRollbackApplicationException(Throwable cause) {
        super(cause);
    }

    public NoRollbackApplicationException(String message, boolean resource, Object... arguments) {
        super(message, resource, arguments);
    }

    public NoRollbackApplicationException(String message, Throwable cause, boolean resource, Object... arguments) {
        super(message, cause, resource, arguments);
    }
}
