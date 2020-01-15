public class ListPartiesCommand implements ICommand {
    private Election election;

    ListPartiesCommand(Election election){
        this.election = election;
    }

    public void execute() {
        System.out.println("Parties\n===========================================================");
        if(election.getParties().isEmpty()){
            System.out.println("There are no parties in the election.");
        }
        else{
            for(Party party : election.getParties()){
                System.out.println("List Number: " + party.getListNumber() + "\n" +
                        "Name: " + party.getName() + "\n" +
                        "Votes: " + election.getNumberOfPartyVotes(party) + "\n" +
                        "Seats: " + election.getNumberOfPartySeats(party));
                System.out.println("-----------------------------------------------------------");
            }
        }
        System.out.println("\n");
    }
}
