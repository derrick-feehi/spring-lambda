package src.main.java.com.spring.lambda.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import src.main.java.com.spring.lambda.model.BookingRecord;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

@Slf4j
@AllArgsConstructor
@Component
public class FreemarkerTemplateBuilder {
    private static final String TEMPLATE_NAME = "Email";
    private final Configuration configuration;

    public String generate(String emailBody, BookingRecord booking) {
        final Writer out = new StringWriter();
        try {
            final Template template = new Template(TEMPLATE_NAME, new StringReader(emailBody), configuration);
            template.process(booking, out);
        } catch (TemplateException | IOException e) {
            log.error("Error parsing template with freemarker {}", e.getMessage(), e);
        }
        return out.toString();
    }
}