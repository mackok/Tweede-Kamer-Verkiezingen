import java.time.LocalDateTime;

public abstract class DateTimeAssignable {
    private LocalDateTime submittedDateTime;

    DateTimeAssignable(LocalDateTime submittedDateTime){
        this.submittedDateTime = submittedDateTime;
    }

    public LocalDateTime getSubmittedDateTime() {
        return submittedDateTime;
    }
}
