package src.main.java.com.spring.lambda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class FreemarkerConfig {
    @Bean
    public freemarker.template.Configuration configuration() {
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return configuration;
    }
}