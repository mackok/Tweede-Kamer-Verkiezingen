import java.time.LocalDateTime;
import java.util.HashSet;

public class Party {
    private int listNumber;
    private String name;
    private HashSet<Vote> votes;
    private HashSet<Seat> seats;
    private LocalDateTime lastVoteDateTime;
    private LocalDateTime lastSeatAssignedDateTime;

    Party(int listNumber, String name){
        this.listNumber = listNumber;
        this.name = name;
        votes = new HashSet<>();
        seats = new HashSet<>();
        lastVoteDateTime = null;
        lastSeatAssignedDateTime = null;
    }

    public int getListNumber(){
        return listNumber;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfVotes(){
        return votes.size();
    }

    public int getAmountOfSeats(){
        return seats.size();
    }

    public void addVote(Vote vote){
        votes.add(vote);
        lastVoteDateTime = vote.getSubmittedDateTime();
    }

    public void addSeat(Seat seat){
        seats.add(seat);
        lastSeatAssignedDateTime = seat.getSubmittedDateTime();
    }

    public String toString(){
        return "List Number: " + listNumber + "\nName: " + name + "\nVotes: " + getAmountOfVotes() + "\nDate of Last Vote: " + lastVoteDateTime + "\nSeats: " + getAmountOfSeats() + "\nDate of Last Seat Assigned: " + lastSeatAssignedDateTime;
    }
}
