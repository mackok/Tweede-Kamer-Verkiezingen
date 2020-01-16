package app;

import java.util.Scanner;

/**
 * Class that represents the "add party" command.
 * @author Maartje Kok
 */
public class AddPartyCommand extends AddCommand<String> {
    /**
     * Constructor method of the class. Initiates fields.
     * @param scanner   the scanner that is being used to read user input.
     * @param election  the election in which the command has to be executed.
     */
    public AddPartyCommand(Scanner scanner, Election election) {
        super(scanner, election);
    }

    /**
     * Asks the user for information.
     * @return  the information the user has provided.
     */
    String ask() {
        System.out.println("Please enter the name of the party.");
        return scanner.nextLine();
    }

    /**
     * Executes the command. In this case it adds a party to the election.
     */
    public void execute() {
        int listNumber = election.getParties().size()+1;
        String name = ask();
        election.addParty(new Party(listNumber, name));
        System.out.println("app.Party successfully added to the election.\n");
    }
}
