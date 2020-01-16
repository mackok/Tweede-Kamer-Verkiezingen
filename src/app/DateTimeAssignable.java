package app;

import java.time.LocalDate;

/**
 * Abstract class that represents an assignable (vote or seat) that keeps track of the date when it was created.
 */
public abstract class DateTimeAssignable {
    /**
     * The date the assignable was created.
     */
    private LocalDate submittedDate;

    /**
     * Constructor method of the class. Initiates fields.
     * @param submittedDate the date the assignable was created.
     */
    DateTimeAssignable(LocalDate submittedDate){
        this.submittedDate = submittedDate;
    }

    /**
     * Gets the date the assignable was created.
     * @return  the date the assignable was created.
     */
    public LocalDate getSubmittedDate() {
        return submittedDate;
    }
}
