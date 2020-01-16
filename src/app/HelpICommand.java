package app;

/**
 * Class that represents the "help" command.
 * @author Maartje Kok
 */
public class HelpICommand implements ICommand {
    /**
     * Executes the command. In this case it prints a list of all possible commands.
     */
    public void execute() {
        System.out.println("Commands\n" +
                "===========================================================\n" +
                "add party - Add a new party to the system.\n" +
                "add votes - Assign a number of votes to a party.\n" +
                "distribute seats - Distribute all seats according to the votes.\n" +
                "parties - Shows a list of all parties.\n" +
                "quit - Quit the program.\n");
    }
}
