package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Handles the interaction with the user.
 * @author Maartje Kok
 */
public class InteractionHandler {
    /**
     * The election that needs to be communicated with.
     */
    private Election election;

    /**
     * The scanner that needs to be used to read user input.
     */
    private Scanner scanner;

    /**
     * All the commands that can be executed.
     */
    private HashMap<String,ICommand> commands;

    /**
     * All the commands that need to terminate the program once they have been executed.
     */
    private HashSet<String> doneAfter;

    /**
     * Whether the program is done/needs to be terminated.
     */
    private boolean done;

    /**
     * Constructor method of the class. Initiates fields.
     * @param scanner   the scanner that needs to be used to read user input.
     */
    public InteractionHandler(Scanner scanner){
        this.scanner = scanner;
        election = new Election();
        commands = new HashMap<>();
        doneAfter = new HashSet<>();
        addCommands();
        done = false;
    }

    /**
     * Executes a command.
     * @param command   the command that needs to be executed.
     * @return          true if the string is a valid command and the command has been executed, otherwise false.
     */
    public boolean ExecuteCommand(String command){
        boolean success = true;

        if(commands.containsKey(command)){
            commands.get(command).execute();
        }
        else{
            success = false;
        }

        if(doneAfter.contains(command)){
            done = true;
        }

        return success;
    }

    /**
     * Gets whether the program is done/needs to be terminated.
     * @return  wether the program is done/needs to be terminated.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Adds all valid commands to the handler. Also add the commands that need to terminate the program after they have been executed.
     */
    private void addCommands(){
        commands.put("help", new HelpICommand());
        commands.put("add party", new AddPartyCommand(scanner, election));
        commands.put("add votes", new AddVoteCommand(scanner, election));
        commands.put("distribute seats", new DistributeSeatsICommand(election));
        commands.put("parties", new ListPartiesICommand(election));

        doneAfter.add("distribute seats");
        doneAfter.add("quit");
    }
}
