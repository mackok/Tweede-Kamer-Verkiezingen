public class Vote implements Assignable{
    private Party party;

    public Vote(Party party){
        this.party = party;
    }

    private Party getParty(){
        return party;
    }

    public void assign(){

    }
}
