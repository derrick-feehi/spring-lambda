package src.main.java.com.spring.lambda.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.main.java.com.spring.lambda.model.BookingRecord;

@Repository
public interface BookingRecordRepository extends JpaRepository<BookingRecord, Long> {
}