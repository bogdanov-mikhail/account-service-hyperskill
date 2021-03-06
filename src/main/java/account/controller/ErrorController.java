package account.controller;

import account.response.NotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<NotValidException> handlerNotValidPayment(ConstraintViolationException ex, WebRequest request) {

        NotValidException exception = new NotValidException(HttpStatus.BAD_REQUEST, request.getDescription(false).substring(4), ex.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }


}
