package src.main.java.com.spring.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ses.model.SendEmailResponse;
import src.main.java.com.spring.lambda.model.EmailEventMessage;
import src.main.java.com.spring.lambda.service.EmailSender;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class LambdaFunction {

    private final EmailSender emailSender;

    public String handleRequest(EmailEventMessage message) {
        log.info("INSIDE THE FUNCTION.....");
        return Optional.of(message)
                .flatMap(emailSender::sendEmail)
                .map(SendEmailResponse::messageId)
                .orElse("Error processing message");
    }
}