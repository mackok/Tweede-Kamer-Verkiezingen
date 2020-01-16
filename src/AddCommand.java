import java.util.Scanner;

abstract class AddCommand<T> implements ICommand{
    Scanner scanner;
    Election election;

    AddCommand(Scanner scanner, Election election){
        this.scanner = scanner;
        this.election = election;
    }

    abstract T ask();

    /**
     * Checks if an entered String is a valid number.
     * @param nr    the String that needs to be validated.
     * @return      true if the String is valid, otherwise false.
     */
    boolean isValidNrString(String nr){
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

