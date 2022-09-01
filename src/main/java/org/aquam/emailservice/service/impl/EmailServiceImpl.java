package org.aquam.emailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.aquam.emailservice.model.ConfirmationData;
import org.aquam.emailservice.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public String sendEmail(ConfirmationData confirmationData) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(createMessage(confirmationData.getConfirmationLink()), true);
            helper.setTo(confirmationData.getEmail());
            helper.setSubject("Confirmation email");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new IllegalStateException("failed to send email");
        } catch (Exception e) {
            throw new IllegalStateException("failed to send email");
        }

        return "email to address " + confirmationData.getEmail() + " was sent";
    }

    public String createMessage(String link) {

        return "<div style=\"margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">\n" +
                "    <p>Hey, thank you for registering :)</p>\n" +
                "    <p>Please click on the link below to activate your account</p>\n" +
                "    <p style=\"margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">\n" +
                "        <a href=\"" + link + "\">Activate account</a>\n" +
                "    </p>\n" +
                "    <p>See you soon!</p>\n" +
                "</div>";
    }
}
