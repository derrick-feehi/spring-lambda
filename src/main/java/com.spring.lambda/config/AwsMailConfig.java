package src.main.java.com.spring.lambda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.ses.SesClient;

@Configuration
public class AwsMailConfig {
    @Bean
    public SesClient sesClient() {
        return SesClient.builder().build();
    }
}