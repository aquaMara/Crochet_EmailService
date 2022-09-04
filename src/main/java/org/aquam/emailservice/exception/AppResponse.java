package org.aquam.emailservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
public class AppResponse {

    private final String message;
    private final HttpStatus httpStatus;
}
