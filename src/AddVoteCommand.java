import java.util.HashMap;
import java.util.Scanner;

public class AddVoteCommand extends AddCommand<HashMap<String, Integer>> {
    AddVoteCommand(Scanner scanner, Election election) {
        super(scanner, election);
    }

    HashMap<String, Integer> ask() {
        HashMap<String, Integer> answers = new HashMap<>();
        answers.put("listNr", askListNr());
        answers.put("amountOfVotes", askAmountOfVotes());
        return answers;
    }

    public void execute() {
        HashMap<String, Integer> answers = ask();
        int listNr = answers.get("listNr");
        int votes = answers.get("amountOfVotes");
        election.addVotesToParty(listNr, votes);
        System.out.println("The votes have been successfully added to the party.");
    }

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
