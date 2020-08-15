package org.emela.chautari.exception;

public class RentalServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RentalServiceException() {
        super();
    }

    public RentalServiceException(String message, Throwable throwable) {
        super(message, throwable);

    }

    public RentalServiceException(String message) {
        super(message);

    }

    public RentalServiceException(Throwable throwable) {
        super(throwable);

    }
}
