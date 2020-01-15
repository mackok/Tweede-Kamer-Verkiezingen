import java.util.Scanner;

public class AddPartyCommand extends ResponseCommand<String>{
    AddPartyCommand(Scanner scanner, Election election) {
        super(scanner, election);
    }

    String ask() {
        System.out.println("Please enter the name of the party.");
        return scanner.nextLine();
    }

    public void execute() {
        int listNumber = election.getParties().size()+1;
        String name = ask();
        election.addParty(new Party(listNumber, name));
        System.out.println("Party successfully added to the election.\n");
    }
}
