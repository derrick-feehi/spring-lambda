package src.main.java.com.spring.lambda.db;


import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.com.spring.lambda.model.EmailTemplate;

import java.util.Optional;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
    Optional<EmailTemplate> findByLanguageIdAndEventType(Long id, int code);
}