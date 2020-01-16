package app;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents the election.
 * @author Maartje Kok
 */
public class Election {
    /**
     * The collection of all the parties participating in the election.
     */
    private ArrayList<Party> parties;

    /**
     * Constant value of the amount of seats that need to be distributed.
     */
    private final int amountOfSeats = 150;

    /**
     * The amount of votes a party needs to have to get 1 seat.
     */
    private double quota;

    /**
     * Constructor method of the class. Initiates fields.
     */
    public Election(){
        parties = new ArrayList<>();
        quota = 0;
    }

    /**
     * Gets the collection of all the parties participating in the election.
     * @return  the collection of all the parties participating in the election.
     */
    public ArrayList<Party> getParties() {
        return parties;
    }

    /**
     * Gets a party from the collection of all the parties participating in the election.
     * @param listNumber    the list number of the party that needs to be acquired from the collection of all the parties participating in the election.
     * @return              the party from the collection of all the parties participating in the election that has the same list number.
     */
    public Party getParty(int listNumber){
        Party result;

        try{
            result = parties.get(listNumber-1);
        }
        catch (IndexOutOfBoundsException e){
            result = null;
        }

        return result;
    }

    /**
     * Adds a party to the collection of all the parties participating in the election.
     * @param party the party that needs to be added to the collection of all the parties participating in the election.
     */
    public void addParty(Party party){
        parties.add(party);
    }

    /**
     * Adds an amount of votes to a party.
     * @param listNr    list number of the party that needs to receive the votes.
     * @param amount    amount of votes that the party needs to receive.
     */
    public void addVotesToParty(int listNr, int amount){
        Party party = getParty(listNr);
        for(int i = amount; i > 0; i--){
            party.addVote(new Vote(LocalDate.now()));
        }
    }

    /**
     * Adds an amount of seats to a party.
     * @param party     party that needs to receive the seats.
     * @param amount    amount of seats that the party needs to receive.
     */
    private void addSeatsToParty(Party party, int amount){
        for(int i = amount; i > 0; i--){
            party.addSeat(new Seat(LocalDate.now()));
        }
    }

    /**
     * Distributes all seats among the parties according to the total amount of votes, the quota and the amount of votes a party has received.
     */
    public void distributeSeats(){
        int totalVotes = 0;
        for(Party party : parties){
            totalVotes += party.getAmountOfVotes();
        }
        calculateQuota(totalVotes);
        assignSeats();
        assignRemainderSeats();
    }

    /**
     * Distributes the seats among the parties.
     */
    private void assignSeats(){
        for(Party party : parties){
            int amount = (int)Math.floor(party.getAmountOfVotes() / quota);
            addSeatsToParty(party, amount);
        }
    }

    /**
     * Distributes the remainder seats among the parties.
     */
    private void assignRemainderSeats(){
        int totalSeats = 0;
        for(Party party : parties){
            totalSeats += party.getAmountOfSeats();
        }
        int amountRemaining = amountOfSeats - totalSeats;
        for(int i = amountRemaining; i > 0; i--){
            Party party = getPartyWithMostVotesPerSeat();
            party.addSeat(new Seat(LocalDate.now()));
        }
    }

    /**
     * Gets the party with the most votes per seat after a remainder seat has been assigned.
     * @return  the party with the most votes per seat after a remainder seat had been assigned.
     */
    private Party getPartyWithMostVotesPerSeat(){
        Party mostVotesPerSeat = null;

        double mostAmountOfVotesPerSeat = 0;
        for(Party party : parties){
            double amountOfVotesPerSeat = party.getAmountOfVotes() / (party.getAmountOfSeats()+1);
            if(amountOfVotesPerSeat > mostAmountOfVotesPerSeat){
                mostAmountOfVotesPerSeat = amountOfVotesPerSeat;
                mostVotesPerSeat = party;
            }
        }

        return mostVotesPerSeat;
    }

    /**
     * Calculates the quota according to the total amount of votes that have been submitted.
     * @param totalVotes    the total amount of votes that have been submitted.
     */
    private void calculateQuota(int totalVotes){
        quota = (double)totalVotes / (double)amountOfSeats;
    }
}
