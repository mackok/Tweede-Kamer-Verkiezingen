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

    public Party getParty(int listNumber){
        Party result = null;

        for(Party party : parties){
            if(party.getListNumber() == listNumber){
                result = party;
            }
        }

        return result;
    }

    public void addParty(Party party){
        parties.add(party);
    }

    public void addVotes(int amount){
        while(amount > 0){
            voteManager.addToCollection(new Vote());
            amount--;
        }
    }

    public void addVotesToParty(Party party, int votes){
        while(votes > 0){
            for(Assignable vote : voteManager.getCollection()){

            }
        }
    }

    /**
     * Checks whether a list number is unique.
     * @param nr    the list number that should be checked.
     * @return      true if the number is unique, otherwise false.
     */
    public boolean isUniqueListNr(int nr){
        boolean unique = true;

        for(Party party : parties){
            if(party.getListNumber() == nr){
                unique = false;
                break;
            }
        }

        return unique;
    }
}
