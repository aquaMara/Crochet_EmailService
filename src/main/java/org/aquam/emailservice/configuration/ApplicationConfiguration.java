package org.aquam.emailservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class ApplicationConfiguration {

    @Value("${spring.mail.host}")
    public String host;
    @Value("${spring.mail.port}")
    public int port;
    @Value("${spring.mail.username}")
    public String username;
    @Value("${spring.mail.password}")
    public String password;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    public String starttls;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", starttls);
        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }
}
