package jp.myapp.exception;

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 1L;

    private boolean resource = false;
    private Object[] arguments = null;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, boolean resource, Object... arguments) {
        super(message);
        this.resource = resource;
        this.arguments = arguments;
    }

    public ApplicationException(String message, Throwable cause, boolean resource, Object... arguments) {
        super(message, cause);
        this.resource = resource;
        this.arguments = arguments;
    }

    public boolean isResource() {
        return resource;
    }

    public Object[] getArguments() {
        return this.arguments;
    }
}
