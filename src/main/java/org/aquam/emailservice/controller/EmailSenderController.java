package org.aquam.emailservice.controller;

import lombok.RequiredArgsConstructor;
import org.aquam.emailservice.model.ConfirmationData;
import org.aquam.emailservice.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendConfirmationEmail(@RequestBody ConfirmationData confirmationData) {
        return new ResponseEntity<>(emailService.sendEmail(confirmationData), HttpStatus.OK);
    }
}
