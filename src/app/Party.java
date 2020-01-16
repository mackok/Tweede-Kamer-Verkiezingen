package app;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * Represents a party in the election.
 * @author Maartje Kok
 */
public class Party {
    /**
     * List number of the party.
     */
    private int listNumber;

    /**
     * Name of the party.
     */
    private String name;

    /**
     * Collection of votes that the party has received.
     */
    private HashSet<Vote> votes;

    /**
     * Collection of seats that have been assigned to the party.
     */
    private HashSet<Seat> seats;

    /**
     * LocalDate of when the last vote was added to the party.
     */
    private LocalDate lastVoteDate;

    /**
     * LocalDate of when the last seat was assigned to the party.
     */
    private LocalDate lastSeatAssignedDate;

    /**
     * Constructor method of the class. Initiates fields.
     * @param listNumber    the list number of the party.
     * @param name          the name of the party
     */
    public Party(int listNumber, String name){
        this.listNumber = listNumber;
        this.name = name;
        votes = new HashSet<>();
        seats = new HashSet<>();
        lastVoteDate = null;
        lastSeatAssignedDate = null;
    }

    /**
     * Gets the list number of the party.
     * @return  the list number of the party.
     */
    public int getListNumber(){
        return listNumber;
    }

    /**
     * Gets the name of the party.
     * @return  the name of the party.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the amount of votes the party has received.
     * @return  the amount of votes the party has received.
     */
    public int getAmountOfVotes(){
        return votes.size();
    }

    /**
     * Gets the amount of seats that have been assigned to the party.
     * @return  the amount of seats that have been assigned to the party.
     */
    public int getAmountOfSeats(){
        return seats.size();
    }

    /**
     * Gets the LocalDate of when the last vote was added to the party.
     * @return  the LocalDate of when the last vote was added to the party.
     */
    public LocalDate getLastVoteDate() {
        return lastVoteDate;
    }

    /**
     * Gets the LocalDate of when the last seat was assigned to the party.
     * @return the LocalDate of when the last seat was assigned to the party.
     */
    public LocalDate getLastSeatAssignedDate() {
        return lastSeatAssignedDate;
    }

    /**
     * Adds a vote to the party.
     * @param vote  the vote that needs to be added to the party.
     */
    public void addVote(Vote vote){
        votes.add(vote);
        lastVoteDate = vote.getSubmittedDate();
    }

    /**
     * Removes all votes from the party.
     */
    public void clearVotes(){
        votes.clear();
    }

    /**
     * Adds a seat to the party.
     * @param seat  the seat that needs to be added to the party.
     */
    public void addSeat(Seat seat){
        seats.add(seat);
        lastSeatAssignedDate = seat.getSubmittedDate();
    }

    /**
     * Removes all seats from the party.
     */
    public void clearSeats(){
        seats.clear();
    }

    /**
     * Override of the toString method.
     * @return  the string that shows information about the party.
     */
    public String toString(){
        return "List Number: " + listNumber + "\nName: " + name + "\nVotes: " + getAmountOfVotes() + "\nDate of Last Vote: " + lastVoteDate + "\nSeats: " + getAmountOfSeats() + "\nDate of Last Seat Assigned: " + lastSeatAssignedDate;
    }
}
