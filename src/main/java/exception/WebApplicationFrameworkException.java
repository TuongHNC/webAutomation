package exception;

public class WebApplicationFrameworkException extends RuntimeException {

    public WebApplicationFrameworkException(String message) {
        super(message);
    }

    public WebApplicationFrameworkException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
