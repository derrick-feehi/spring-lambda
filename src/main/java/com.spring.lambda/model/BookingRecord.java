package src.main.java.com.spring.lambda.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class BookingRecord {

    @Id
    private Integer id;
    private LocalDateTime created;
    private String reference;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String postcode;
    private BigDecimal grandTotal;

}