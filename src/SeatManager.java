import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SeatManager extends Manager{
    private static final int amountOfSeats = 150;
    private ArrayList<Seat> remainderSeats;
    private float quota;

    public SeatManager() {
        super();
        quota = 0;
        generateSeats();
    }

    public ArrayList<Seat> getRemainderSeats() {
        return remainderSeats;
    }

    public int getNumberOfRemainderSeats(){
        return remainderSeats.size();
    }

    private float getQuota(int totalVotes){
        calculateQuota(totalVotes);
        return quota;
    }

    public void addRemainderSeats(int amount, int listNumber){

    }

//    public void distribute(ArrayList<Party> parties, HashSet<Vote> votes) {
//        int i = 0;
//        for(Party party : parties){
//            for(Vote vote : votes){
//                if(vote.getParty() == party){
//                    i++;
//                }
//            }
//        }
//        float quota = getQuota(i);
//        distributeSeats(parties, quota);
//    }
//
//    private void distributeSeats(ArrayList<Party> parties, float quota){
//        for(Party party : parties){
//            int amount = (int)Math.floor(getPartyAssignees(party).size() / quota);
//            addAssignableToParty(party, amount);
//        }
//    }
//
//    private void distributeRemainderSeats(){
//
//    }
//
//    private Party getPartyWithMostVotesPerSeat(HashSet<Party> parties){
//        Party mostVotesPerSeat;
//        int mostAmountOfVotesPerSeat = 0;
//        for(Party party : parties){
//            int amountOfVotesPerSeat =
//        }
//        return mostVotesPerSeat;
//    }

    private void calculateQuota(int totalVotes){
        quota = totalVotes / amountOfSeats;
    }

    private void generateSeats(){
        for(int i = amountOfSeats; i > 0; i--){
            addToCollection(new Seat());
        }
    }
}
