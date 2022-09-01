package org.aquam.emailservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import java.time.ZonedDateTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<AppResponse> handleMessagingException(MessagingException exception) {
        AppResponse response = new AppResponse(exception.getMessage(), ZonedDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppResponse> handleException(RuntimeException exception) {
        AppResponse response = new AppResponse(exception.getMessage(), ZonedDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
