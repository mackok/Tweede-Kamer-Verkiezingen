public class ListPartiesICommand implements ICommand {
    private Election election;

    ListPartiesICommand(Election election){
        this.election = election;
    }

    public void execute() {
        System.out.println("Parties\n===========================================================");
        if(election.getParties().isEmpty()){
            System.out.println("There are no parties in the election.");
        }
        else{
            for(Party party : election.getParties()){
                System.out.println(party.toString());
                System.out.println("-----------------------------------------------------------");
            }
        }
        System.out.println("\n");
    }
}
