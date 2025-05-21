package src.main.java.com.spring.lambda.service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.SendEmailResponse;
import src.main.java.com.spring.lambda.builder.EmailBuilder;
import src.main.java.com.spring.lambda.db.BookingRecordService;
import src.main.java.com.spring.lambda.db.EmailTemplateService;
import src.main.java.com.spring.lambda.model.EmailEventMessage;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class EmailSender {

    private final SesClient sesClient;
    private final BookingRecordService bookingService;
    private final EmailTemplateService emailService;
    private final EmailBuilder emailBuilder;

    public Optional<SendEmailResponse> sendEmail(EmailEventMessage message) {
        final int bookingId = message.getBookingId();
        final int eventType = message.getType();
        final int languageId = message.getLanguageId();

        return bookingService.getBookingRecordByBookingId((long) bookingId)
                .flatMap(booking -> emailService.getTemplateByIdAndCode((long) languageId, eventType)
                        .map(emailTemplate -> {
                            log.info("Email has been fetched for reference {} and type {} with language {}", booking.getReference(), eventType, languageId);
                            return emailBuilder.buildEmailRequest(emailTemplate, booking);
                        }))
                .map(sesClient::sendEmail);
    }
}