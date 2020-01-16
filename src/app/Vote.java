import java.time.LocalDateTime;

/**
 * Represents a vote in the election.
 * @author Maartje Kok
 */
class Vote extends DateTimeAssignable {
    /**
     * Constructor method of the class. Initiates fields.
     * @param submittedDateTime  The LocalDateTime of when the vote was submitted/created.
     */
    Vote(LocalDateTime submittedDateTime) {
        super(submittedDateTime);
    }
}
