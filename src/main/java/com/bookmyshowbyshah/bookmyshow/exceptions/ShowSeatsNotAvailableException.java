package com.bookmyshowbyshah.bookmyshow.exceptions;

public class ShowSeatsNotAvailableException extends RuntimeException {

    public ShowSeatsNotAvailableException() {
    }

    public ShowSeatsNotAvailableException(String message) {
        super(message);
    }

    public ShowSeatsNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShowSeatsNotAvailableException(Throwable cause) {
        super(cause);
    }

    public ShowSeatsNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
