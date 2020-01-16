package app;

import java.time.LocalDate;

/**
 * Represents a vote in the election.
 * @author Maartje Kok
 */
public class Vote extends DateTimeAssignable {
    /**
     * Constructor method of the class. Initiates fields.
     * @param submittedDate  the LocalDateTime of when the vote was submitted/created.
     */
    public Vote(LocalDate submittedDate) {
        super(submittedDate);
    }
}
