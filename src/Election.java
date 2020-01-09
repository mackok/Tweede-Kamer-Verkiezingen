import java.util.ArrayList;
import java.util.HashSet;

public class Election {
    private ArrayList<Party> parties;
    private SeatManager seatManager;
    private VoteManager voteManager;

    public Election(){
        parties = new ArrayList<>();
        seatManager = new SeatManager(new ArrayList<>()); //placeholder parameter
        voteManager = new VoteManager(new HashSet<>()); //placeholder parameter
    }

    public ArrayList<Party> getParties() {
        return parties;
    }

    public void addParty(Party party){
        parties.add(party);
    }
}
