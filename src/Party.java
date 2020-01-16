import java.util.HashSet;

public class Party {
    private int listNumber;
    private String name;
    private HashSet<Vote> votes;
    private HashSet<Seat> seats;

    Party(int listNumber, String name){
        this.listNumber = listNumber;
        this.name = name;
        votes = new HashSet<>();
        seats = new HashSet<>();
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
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    public String toString(){
        return "List Number: " + listNumber + "\nName: " + name + "\nVotes: " + getAmountOfVotes() + "\nSeats: " + getAmountOfSeats();
    }
}
