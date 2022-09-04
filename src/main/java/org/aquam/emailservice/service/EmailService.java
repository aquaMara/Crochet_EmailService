package org.aquam.emailservice.service;

import org.aquam.emailservice.model.ConfirmationData;

public interface EmailService {

    String sendEmail(ConfirmationData confirmationData);
    String createMessageBody(String link);
}
