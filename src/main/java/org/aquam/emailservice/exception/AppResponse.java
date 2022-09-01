package org.aquam.emailservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class AppResponse {

    private String message;
    private ZonedDateTime zonedDateTime;
    private HttpStatus httpStatus;
}
