public class DistributeSeatsCommand implements ICommand {
    private Election election;

    DistributeSeatsCommand(Election election){
        this.election = election;
    }
    public void execute() {
        election.distributeSeats();
        System.out.println("The seats have been successfully distributed.");
        ListPartiesCommand listParties = new ListPartiesCommand(election);
        listParties.execute();
    }
}
