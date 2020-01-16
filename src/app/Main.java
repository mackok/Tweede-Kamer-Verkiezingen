import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InteractionHandler interactionHandler = new InteractionHandler(scanner);
	    String command;

	    boolean done = false;
	    while(!done){
            System.out.println("");
            System.out.println("Welcome to the election management system. Please enter a command. Use the command 'help' to get a list of all possible commands.");
            command = scanner.nextLine();
            System.out.println("\n");
            if(!interactionHandler.ExecuteCommand(command.toLowerCase())){
                System.out.println("Invalid command");
            }
            done = interactionHandler.isDone();
        }
    }
}
