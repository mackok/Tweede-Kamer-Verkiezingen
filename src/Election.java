import java.util.ArrayList;
import java.util.HashSet;

public class Election {
    private ArrayList<Party> parties;
    private SeatManager seatManager;
    private VoteManager voteManager;

    public Election(){
        parties = new ArrayList<>();
        seatManager = new SeatManager();
        voteManager = new VoteManager();
    }

    public ArrayList<Party> getParties() {
        return parties;
    }

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

    public int getNumberOfPartyVotes(Party party){
        return voteManager.getNumberOfPartyVotes(party);
    }

    public void addParty(Party party){
        parties.add(party);
    }

    public void addVotes(int amount){
        voteManager.createVotes(amount);
    }

    public void clearVotes(){
        voteManager.clearCollection();
    }

    public void addVotesToParty(Party party, int votes){
        voteManager.addAssignableToParty(party, votes);

    }

    public int getAmountUnassignedVotes(){
        return voteManager.getAmountUnassignedVotes();
    }
}
