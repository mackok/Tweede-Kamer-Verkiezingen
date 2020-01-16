package tests;

import app.AddPartyCommand;
import app.AddVoteCommand;
import app.Election;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    @Test
    void isValidNrString() {
        AddPartyCommand addCommand = new AddPartyCommand(new Scanner(System.in), new Election());
        assertTrue(addCommand.isValidNrString("1"));
    }

    @Test
    void isInvalidNrString(){
        AddVoteCommand addCommand = new AddVoteCommand(new Scanner(System.in), new Election());
        assertFalse(addCommand.isValidNrString("één"));
    }
}