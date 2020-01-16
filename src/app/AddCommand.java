package app;

import java.util.Scanner;

/**
 * Abstract class that represents a command that needs to add something to the election.
 * @author Maartje Kok
 */
abstract class AddCommand<T> implements ICommand{
    /**
     * The scanner that is being used to read user input.
     */
    Scanner scanner;

    /**
     * The election in which the command has to be executed.
     */
    Election election;

    /**
     * Constructor method of the class. Initiates fields.
     * @param scanner   the scanner that is being used to read user input.
     * @param election  the election in which the command has to be executed.
     */
    AddCommand(Scanner scanner, Election election){
        this.scanner = scanner;
        this.election = election;
    }

    /**
     * Asks the user for information.
     * @return  the information the user has provided.
     */
    abstract T ask();

    /**
     * Checks if an entered String is a valid number.
     * @param nr    the String that needs to be validated.
     * @return      true if the String is valid, otherwise false.
     */
    public boolean isValidNrString(String nr){
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

