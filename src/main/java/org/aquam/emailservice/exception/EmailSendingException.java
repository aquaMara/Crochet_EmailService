package org.aquam.emailservice.exception;

public class EmailSendingException extends RuntimeException {

    public EmailSendingException() {
    }

    public EmailSendingException(String message) {
        super(message);
    }
}
