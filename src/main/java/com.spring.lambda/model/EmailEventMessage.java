package src.main.java.com.spring.lambda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailEventMessage {
    private Integer bookingId;
    private Integer languageId;
    private Integer type;
}