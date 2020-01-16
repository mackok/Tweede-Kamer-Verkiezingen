package app;

import java.time.LocalDate;

/**
 * Represents a seat in the election.
 * @author Maartje Kok
 */
public class Seat extends DateTimeAssignable{
    /**
     * Constructor method of the class. Initiates fields.
     * @param submittedDate  the LocalDateTime of when the seat was submitted/created.
     */
    public Seat(LocalDate submittedDate) {
        super(submittedDate);
    }
}
