package src.main.java.com.spring.lambda.db;

import org.springframework.stereotype.Service;
import src.main.java.com.spring.lambda.model.EmailTemplate;

import java.util.Optional;

@Service
public class EmailTemplateService {

    private final EmailTemplateRepository templateRepository;

    public EmailTemplateService(EmailTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Optional<EmailTemplate> getTemplateByIdAndCode(Long languageId, int eventType) {
        return templateRepository.findByLanguageIdAndEventType(languageId, eventType);
    }
}