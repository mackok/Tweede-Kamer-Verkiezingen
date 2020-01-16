public class DistributeSeatsICommand implements ICommand {
    private Election election;

    DistributeSeatsICommand(Election election){
        this.election = election;
    }
    public void execute() {
        election.distributeSeats();
        System.out.println("The seats have been successfully distributed.");
        ListPartiesICommand listParties = new ListPartiesICommand(election);
        listParties.execute();
    }
}
