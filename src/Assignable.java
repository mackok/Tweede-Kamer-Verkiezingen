public abstract class Assignable{
    private Party party;

    public Assignable(){
        party = null;
    }

    public void assign(Party party){
        this.party = party;
    }

    public Party getParty(){
        return party;
    }
}
