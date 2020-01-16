package tests;

import app.Seat;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of the Seat class.
 * @author Maartje Kok
 */
class SeatTest {
    private final LocalDate now = LocalDate.now();

    @Test
    void pSubmittedDateTime(){
        Seat seat = new Seat(now);
        assertEquals(now, seat.getSubmittedDate());
    }

    @Test
    void nSubmittedDateTime(){
        Seat seat = new Seat(now);
        assertNotEquals(now.plusDays(2), seat.getSubmittedDate());
    }
}