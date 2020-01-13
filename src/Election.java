import java.util.ArrayList;
import java.util.HashSet;

public class Election {
    private ArrayList<Party> parties;
    private SeatManager seatManager;
    private VoteManager voteManager;

    public Election(){
        parties = new ArrayList<>();
        seatManager = new SeatManager(new ArrayList<>());
        voteManager = new VoteManager(new HashSet<>());
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

    public int getNumberOfPartyVotes(Party party){
        int i = 0;

        for(Assignable vote : voteManager.getCollection()){
            if(vote.getParty() == party && vote.getParty() != null){
                i++;
            }
        }

        return i;
    }

    public float getQuota(){
        int i = 0;

        for(Assignable vote : voteManager.getCollection()){
            if(vote.getParty() != null){
                i++;
            }
        }

        return seatManager.getQuota(i);
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

    public void clearVotes(){
        voteManager.clearCollection();
    }

    public void addVotesToParty(Party party, int votes){
        for(Assignable vote : voteManager.getCollection()){
            if(vote.getParty() == null && votes > 0){
                vote.assign(party);
                votes--;
            }
            if(votes <= 0){
                break;
            }
        }

    }

    public int getAmountUnassignedVotes(){
        int i = 0;
        for(Assignable vote : voteManager.getCollection()){
            if(vote.getParty() == null){
                i++;
            }
        }
        return i;
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
