package app;

/**
 * Class that represents the "distribute seats" command.
 * @author Maartje Kok
 */
public class DistributeSeatsICommand implements ICommand {
    /**
     * The election in which the command has to be executed.
     */
    private Election election;

    /**
     * Constructor method of the class. Initiates fields.
     * @param election  the election in which the command has to be executed.
     */
    DistributeSeatsICommand(Election election){
        this.election = election;
    }

    /**
     * Executes the command. In this case it distributes all seats between the parties.
     */
    public void execute() {
        election.distributeSeats();
        System.out.println("The seats have been successfully distributed.");
        ListPartiesICommand listParties = new ListPartiesICommand(election);
        listParties.execute();
    }
}
