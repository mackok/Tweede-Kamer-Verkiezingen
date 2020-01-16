package app;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class that represents the "add vote" command.
 * @author Maartje Kok
 */
public class AddVoteCommand extends AddCommand<HashMap<String, Integer>> {
    /**
     * Constructor method of the class. Initiates fields.
     * @param scanner   the scanner that is being used to read user input.
     * @param election  the election in which the command has to be executed.
     */
    public AddVoteCommand(Scanner scanner, Election election) {
        super(scanner, election);
    }

    /**
     * Asks the user for information.
     * @return  the information the user has provided.
     */
    public HashMap<String, Integer> ask() {
        HashMap<String, Integer> answers = new HashMap<>();
        answers.put("listNr", askListNr());
        answers.put("amountOfVotes", askAmountOfVotes());
        return answers;
    }

    /**
     * Executes the command. In this case it adds an amount of votes to a party.
     */
    public void execute() {
        HashMap<String, Integer> answers = ask();
        int listNr = answers.get("listNr");
        int votes = answers.get("amountOfVotes");
        election.addVotesToParty(listNr, votes);
        System.out.println("The votes have been successfully added to the party.");
    }

    /**
     * Asks the user for the list number of the party the votes have to be added to.
     * @return  the list number of the party the votes have to be added to.
     */
    private int askListNr(){
        ListPartiesICommand listParties = new ListPartiesICommand(election);
        listParties.execute();
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

    /**
     * Asks the user for the amount of votes that have to be added to the party.
     * @return  the amount of votes that have to be added to the party.
     */
    private int askAmountOfVotes(){
        boolean go = true;
        int votes = 0;
        while(go){
            System.out.println("Please enter the amount of votes you want to add to the party.");

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
}
