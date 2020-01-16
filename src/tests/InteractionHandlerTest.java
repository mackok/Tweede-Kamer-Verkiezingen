package tests;

import app.Election;
import app.InteractionHandler;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InteractionHandlerTest {
    private InteractionHandler interactionHandler = new InteractionHandler(new Scanner(System.in));

    @Test
    void pExecuteCommand() {
        assertTrue(interactionHandler.ExecuteCommand("help"));
    }

    @Test
    void nExecuteCommand() {
        assertFalse(interactionHandler.ExecuteCommand("print"));
    }

    @Test
    void isDone() {
        interactionHandler = new InteractionHandler(new Scanner(System.in));
        interactionHandler.ExecuteCommand("quit");
        assertTrue(interactionHandler.isDone());
    }

    @Test
    void isNotDone(){
        interactionHandler = new InteractionHandler(new Scanner(System.in));
        interactionHandler.ExecuteCommand("help");
        assertFalse(interactionHandler.isDone());
    }
}