import java.util.HashSet;

public class VoteManager extends Manager {

    public VoteManager() {
        super();
    }

    public void createVotes(int amount){
        while(amount > 0){
            addToCollection(new Vote());
            amount--;
        }
    }

    public int getAmountUnassignedVotes(){
        int i = 0;
        for(Assignable vote : getCollection()){
            if(vote.getParty() == null){
                i++;
            }
        }
        return i;
    }

    public int getNumberOfPartyVotes(Party party){
        return getPartyAssignees(party).size();
    }
}
