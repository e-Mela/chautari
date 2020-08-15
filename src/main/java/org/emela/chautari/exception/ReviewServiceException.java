package org.emela.chautari.exception;

public class ReviewServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public ReviewServiceException() {
        super();
    }


    public ReviewServiceException(String message, Throwable throwable) {
        super(message, throwable);

    }

    public ReviewServiceException(String message) {
        super(message);

    }

    public ReviewServiceException(Throwable throwable) {
        super(throwable);

    }
}
