package org.emela.chautari.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * default constructor.
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * RefundServiceAPIException
     *
     * @param message
     * @param throwable
     */
    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);

    }

    /**
     * RefundServiceAPIException
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);

    }

    /**
     * RefundServiceAPIException
     *
     * @param throwable
     */
    public ResourceNotFoundException(Throwable throwable) {
        super(throwable);

    }
}
