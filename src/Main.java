import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Election election = new Election();
	    boolean done = false;
	    String command;
	    int totalVotes = askAmountOfVotes(scanner, true);
	    election.addVotes(totalVotes);

	    while(!done){
            System.out.println("");
            System.out.println("Welcome to the election management system. Please enter a command. Use the command 'help' to get a list of all possible commands.");
            command = scanner.nextLine();
            System.out.println("\n");
            boolean go = true;
            switch (command.toLowerCase()){
                case "help":
                    printHelp();
                    break;

                case "add party":
                    int listNumber = election.getParties().size()+1;
                    String name = askName(scanner);
                    election.addParty(new Party(listNumber, name));
                    System.out.println("Party successfully added to the election.\n");
                    break;

                case "add votes":
                    int listNr = askListNumber(scanner, election);
                    go = true;
                    while(go){
                        int votes = askAmountOfVotes(scanner, false);
                        if(votes > totalVotes){
                            System.out.println("The amount of votes to assign can't be bigger than the total amount of votes.");
                        }
                        else if(election.getAmountUnassignedVotes() < votes){
                            System.out.println("There are not enough total votes left to assign " + votes + " votes to " + election.getParty(listNr).getName() + ", try again.");
                        }
                        else{
                            election.addVotesToParty(election.getParty(listNr), votes);
                            System.out.println("The votes have been successfully added to the party.");
                            go = false;
                        }
                    }
                    break;

                case "change total votes":
                    totalVotes = askAmountOfVotes(scanner, true);
                    election.clearVotes();
                    election.addVotes(totalVotes);
                    break;

                case "distribute seats":
                    go = true;
                    while(go){
                        if(election.getAmountUnassignedVotes() == totalVotes){
                            System.out.println("Please assign at least 1 vote to one of the parties.");
                        }
                        else{

                        }
                    }

                    break;

                case "parties":
                    printParties(election);
                    break;

                case "quit":
                    done = true;
                    break;

                default:
                    System.out.println("Invalid command");
                    break;

            }
        }
    }

    private static void printHelp(){
        System.out.println("Commands\n" +
                "===========================================================\n" +
                "add party - Add a new party to the system.\n" +
                "add votes - Assign a number of votes to a party.\n" +
                "change total votes - Change the total amount of votes that can be assigned.\n" +
                "distribute seats - Distribute all seats according to the votes.\n" +
                "parties - Shows a list of all parties.\n" +
                "quit - Quit the program.\n");
    }

    private static void printParties(Election election){
        System.out.println("Parties\n===========================================================");
        if(election.getParties().isEmpty()){
            System.out.println("There are no parties in the election.");
        }
        else{
            for(Party party : election.getParties()){
                System.out.println("List Number: " + party.getListNumber() + "\n" +
                "Name: " + party.getName() + "\n" +
                "Votes: " + election.getNumberOfPartyVotes(party));
                System.out.println("-----------------------------------------------------------");
            }
        }
        System.out.println("\n");
    }

    private static int askListNumber(Scanner scanner, Election election){
        printParties(election);
        boolean go = true;
        int listNr = 0;
        while(go){
            System.out.println("Please enter the list number of the party.");
            String listNrString = scanner.nextLine();
            if(!isValidNrString(listNrString)){
                System.out.println("This is an invalid list number format, try again.");
            }
            else{
                listNr = Integer.parseInt(listNrString);
                if(election.getParty(listNr) == null){
                    System.out.println("There is no party with this list number, try again.");
                }
                else{
                    go = false;
                }
            }
        }

        return listNr;
    }

    private static int askAmountOfVotes(Scanner scanner, boolean isTotal){
        boolean go = true;
        int votes = 0;
        while(go){
            if(isTotal){
                System.out.println("Please enter the total amount of votes in the election.");
            }
            else {
                System.out.println("Please enter the amount of votes you want to add to the party.");
            }

            String votesString = scanner.nextLine();
            if(!isValidNrString(votesString)){
                System.out.println("This is an invalid number format, try again.");
            }
            else{
                votes = Integer.parseInt(votesString);
                if(votes == 0){
                    System.out.println("The number of votes can't be 0, try again.");
                }
                else{
                    go = false;
                }
            }
        }

        return votes;
    }

    private static String askName(Scanner scanner){
        System.out.println("Please enter the name of the party.");
        return scanner.nextLine();
    }

    /**
     * Checks if an entered String is a valid number.
     * @param nr    the String that needs to be validated.
     * @return      true if the String is valid, otherwise false.
     */
    private static boolean isValidNrString(String nr){
        boolean valid = true;

        try{
            if(Integer.parseInt(nr) < 0){
                valid = false;
            }
        } catch (NumberFormatException | NullPointerException nfe){
            valid = false;
        }

        return valid;
    }
}
