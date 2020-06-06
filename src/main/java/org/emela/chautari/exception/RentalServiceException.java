package org.emela.chautari.exception;

public class RentalServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * default constructor.
     */
    public RentalServiceException() {
        super();
    }

    /**
     * RefundServiceAPIException
     *
     * @param message
     * @param throwable
     */
    public RentalServiceException(String message, Throwable throwable) {
        super(message, throwable);

    }

    /**
     * RefundServiceAPIException
     *
     * @param message
     */
    public RentalServiceException(String message) {
        super(message);

    }

    /**
     * RefundServiceAPIException
     *
     * @param throwable
     */
    public RentalServiceException(Throwable throwable) {
        super(throwable);

    }
}
