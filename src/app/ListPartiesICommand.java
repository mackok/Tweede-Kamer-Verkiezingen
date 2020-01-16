package app;

/**
 * Class that represents the "parties" command.
 * @author Maartje Kok
 */
public class ListPartiesICommand implements ICommand {
    /**
     * The election in which the command has to be executed.
     */
    private Election election;

    /**
     * Constructor method of the class. Initiates fields.
     * @param election the election in which the command has to be executed.
     */
    ListPartiesICommand(Election election){
        this.election = election;
    }

    /**
     * Executes the command. In this case it prints a list of all the parties.
     */
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
