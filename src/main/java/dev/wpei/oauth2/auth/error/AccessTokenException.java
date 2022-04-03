package dev.wpei.oauth2.auth.error;

public class AccessTokenException extends RuntimeException{
    public AccessTokenException() {
        super();
    }

    public AccessTokenException(String message) {
        super(message);
    }

    public AccessTokenException(Throwable throwable) {
        super(throwable);
    }

    public AccessTokenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
