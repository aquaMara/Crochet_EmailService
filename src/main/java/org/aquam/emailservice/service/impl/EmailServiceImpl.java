package org.aquam.emailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.aquam.emailservice.model.ConfirmationData;
import org.aquam.emailservice.service.EmailService;
freimport org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final ApplicationConfiguration applicationConfiguration;
    private static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public String sendEmail(ConfirmationData confirmationData) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(createMessageBody(confirmationData.getConfirmationLink()), true);
            helper.setTo(confirmationData.getEmail());
            helper.setSubject("Confirmation email");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("Class: " + e.getClass() + " Message: " + e.getMessage() + " User email: " + confirmationData.getEmail());
            throw new EmailSendingException("Failed to send email, check email address");
        }

        return "email to address " + confirmationData.getEmail() + " was sent";
    }

    @Override
    public String createMessageBody(String link) {
        Template template = applicationConfiguration.factoryBean().createConfiguration().getTemplate("email.ftlh");
        Map<String, String> model = new HashMap<>();
        model.put("name", "NNNN");
        model.put("username", "NNNN");
        model.put("link", "https://yandex.by/");
        return htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }
}
