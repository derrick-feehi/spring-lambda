package src.main.java.com.spring.lambda.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmailTemplate {
    @Id
    private int id;
    private int eventType;
    private String subject;
    private String senderName;
    private String senderAddress;
    private String bodyHtml;
    private int languageId;
}
