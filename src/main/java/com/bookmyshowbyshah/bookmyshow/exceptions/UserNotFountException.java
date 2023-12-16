package com.bookmyshowbyshah.bookmyshow.exceptions;

public class UserNotFountException extends RuntimeException{
    public UserNotFountException() {
    }

    public UserNotFountException(String message) {
        super(message);
    }

    public UserNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFountException(Throwable cause) {
        super(cause);
    }

    public UserNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
