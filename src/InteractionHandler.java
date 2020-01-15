import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class InteractionHandler {
    private Election election;
    private Scanner scanner;
    private HashMap<String,ICommand> commands;
    private HashSet<String> doneAfter;
    private boolean done;

    InteractionHandler(Scanner scanner){
        this.scanner = scanner;
        election = new Election();
        commands = new HashMap<>();
        doneAfter = new HashSet<>();
        addCommands();
        done = false;
    }

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

    public boolean isDone() {
        return done;
    }

    private void addCommands(){
        commands.put("help", new HelpICommand());
        commands.put("add party", new AddPartyCommand(scanner, election));
        commands.put("add votes", new AddVoteCommand(scanner, election));
        commands.put("distribute seats", new DistributeSeatsCommand(election));
        commands.put("parties", new ListPartiesCommand(election));

        doneAfter.add("distribute seats");
        doneAfter.add("quit");
    }
}
