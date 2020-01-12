public class Vote implements Assignable{
    private Party party;

    public Vote(){
        party = null;
    }

    private Party getParty(){
        return party;
    }

    public void assign(Party party){
        this.party = party;
    }
}
