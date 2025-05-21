package src.main.java.com.spring.lambda.builder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ses.model.*;
import src.main.java.com.spring.lambda.freemarker.FreemarkerTemplateBuilder;
import src.main.java.com.spring.lambda.model.BookingRecord;
import src.main.java.com.spring.lambda.model.EmailTemplate;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailBuilder {
    private static final String SEPARATOR = "-";

    private final FreemarkerTemplateBuilder freemarkerTemplateBuilder;

    public SendEmailRequest buildEmailRequest(EmailTemplate emailTemplate, BookingRecord booking) {
        log.info("Build email request  reference {}", booking.getReference());
        return SendEmailRequest.builder()
                .destination(buildDestination(booking.getEmailAddress()))
                .message(buildMessage(emailTemplate, booking))
                .source(emailTemplate.getSenderAddress())
                .build();
    }

    private Destination buildDestination(String toAddress) {
        return Destination.builder()
                .toAddresses(toAddress)
                .build();
    }
    private Message buildMessage(final EmailTemplate email, BookingRecord booking) {
        return Message.builder()
                .body(Body.builder()
                        .html(Content.builder()
                                .charset(StandardCharsets.UTF_8.name())
                                .data(freemarkerTemplateBuilder.generate(email.getBodyHtml(), booking))
                                .build())
                        .build())
                .subject(Content.builder()
                        .charset(StandardCharsets.UTF_8.name())
                        .data(email.getSubject())
                        .build())
                .build();
    }
}