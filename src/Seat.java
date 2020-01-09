public class Seat implements Assignable {
    private Party party;

    public Seat(Party party){
        this.party = party;
    }

    public Party getParty() {
        return party;
    }

    public void assign() {

    }
}
