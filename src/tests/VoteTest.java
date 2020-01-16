package tests;

import app.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

/**
 * Test class of the Vote class.
 * @author Maartje Kok
 */
class VoteTest {
    private final LocalDate now = LocalDate.now();

    @Test
    void pSubmittedDateTime(){
        Vote vote = new Vote(now);
        assertEquals(now, vote.getSubmittedDate());
    }

    @Test
    void nSubmittedDateTime(){
        Vote vote = new Vote(now);
        assertNotEquals(now.plusDays(2), vote.getSubmittedDate());
    }
}