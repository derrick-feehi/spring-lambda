package src.main.java.com.spring.lambda.db;

import org.springframework.stereotype.Service;
import src.main.java.com.spring.lambda.model.BookingRecord;

import java.util.Optional;

@Service
public class BookingRecordService {

    private final BookingRecordRepository bookingRecordRepository;

    public BookingRecordService(BookingRecordRepository bookingRecordRepository) {
        this.bookingRecordRepository = bookingRecordRepository;
    }

    public Optional<BookingRecord> getBookingRecordByBookingId(Long bookingId) {
        return bookingRecordRepository.findById(bookingId);
    }
}