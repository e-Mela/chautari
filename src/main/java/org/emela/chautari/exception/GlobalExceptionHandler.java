package org.emela.chautari.exception;

import org.emela.chautari.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RentalServiceException.class)
    public ResponseEntity<ErrorModel> handleInvoiceServiceException(Exception e) {
        ErrorModel errorModel = buildErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.name(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e);
        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorModel> handleMethodNotFoundException(Exception e) {
        return new ResponseEntity<>(buildErrorModel(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                String.valueOf(HttpStatus.NOT_FOUND.value()), e), HttpStatus.NOT_FOUND);
    }


    private ErrorModel buildErrorModel(String developerMessage, String userMessage, String errorCode, Exception e) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setDeveloperMessage(developerMessage);
        errorModel.setUserMessage(userMessage);
        errorModel.setErrorCode(errorCode);
        errorModel.setMoreInfo(e.getMessage());
        return errorModel;
    }
}
