import java.util.HashMap;
import java.util.HashSet;

public abstract class Manager {
    private HashSet<Assignable> collection;

    public Manager(){ this.collection = new HashSet<>(); }

    public HashSet<Assignable> getCollection(){
        return collection;
    }

    public void addToCollection(Assignable item){
        collection.add(item);
    }

    public void clearCollection(){
        collection.clear();
    }

    public void addAssignableToParty(Party party, int amount){
        for(Assignable assignable : getCollection()){
            if(assignable.getParty() == null && amount > 0){
                assignable.assign(party);
                amount--;
            }
            if(amount <= 0){
                break;
            }
        }
    }

    public HashMap<Party,HashSet<Assignable>> getSortedAssignees(){
        HashSet<Party> parties = new HashSet<>();
        for(Assignable assignable : getCollection()){
            if(!parties.contains(assignable.getParty())){
                parties.add(assignable.getParty());
            }
        }

        HashMap<Party, HashSet<Assignable>> sortedVotes = new HashMap<>();
        for(Party party : parties){
            sortedVotes.put(party, getPartyAssignees(party));
        }

        return sortedVotes;
    }

    protected HashSet<Assignable> getPartyAssignees(Party party){
        HashSet<Assignable> assignees = new HashSet<>();
        for(Assignable assignable : getCollection()){
            if(assignable.getParty() == party){
                assignees.add(assignable);
            }
        }
        return assignees;
    }

    public int getNumberOfAssignables(){
        return collection.size();
    }
}
