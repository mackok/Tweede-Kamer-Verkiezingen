package tests;

import app.Party;
import app.Seat;
import app.Vote;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of the Party class.
 * @author Maartje Kok
 */
class PartyTest {
    private final int listNr = 1;
    private final String name = "De Partij";
    private final LocalDate date = LocalDate.now();
    private Party party = new Party(listNr, name);

    @Test
    void pGetListNumber() {
        assertEquals(listNr, party.getListNumber());
    }

    @Test
    void nGetListNumber() {
        assertNotEquals(2, party.getListNumber());
    }

    @Test
    void pGetName() {
        assertEquals(name, party.getName());
    }

    @Test
    void nGetName() {
        assertNotEquals("Partij", party.getName());
    }

    @Test
    void pGetAmountOfVotes() {
        party.clearVotes();
        party.addVote(new Vote(date));
        party.addVote(new Vote(date));
        assertEquals(2, party.getAmountOfVotes());
    }

    @Test
    void nGetAmountOfVotes() {
        party.clearVotes();
        party.addVote(new Vote(date));
        party.addVote(new Vote(date));
        assertNotEquals(1, party.getAmountOfVotes());
    }

    @Test
    void pGetAmountOfSeats() {
        party.clearSeats();
        party.addSeat(new Seat(date));
        party.addSeat(new Seat(date));
        assertEquals(2, party.getAmountOfSeats());
    }

    @Test
    void nGetAmountOfSeats() {
        party.clearSeats();
        party.addSeat(new Seat(date));
        party.addSeat(new Seat(date));
        assertNotEquals(1, party.getAmountOfSeats());
    }

    @Test
    void pAddVote() {
        party.clearVotes();
        party.addVote(new Vote(date));
        assertEquals(1, party.getAmountOfVotes());
    }

    @Test
    void nAddVote() {
        party.clearVotes();
        party.addVote(new Vote(date));
        assertNotEquals(0, party.getAmountOfVotes());
    }

    @Test
    void pAddSeat() {
        party.clearSeats();
        party.addSeat(new Seat(date));
        assertEquals(1, party.getAmountOfSeats());
    }

    @Test
    void nAddSeat() {
        party.clearSeats();
        party.addSeat(new Seat(date));
        assertNotEquals(0, party.getAmountOfSeats());
    }

    @Test
    void pClearVotes(){
        party.clearVotes();
        party.addVote(new Vote(date));
        party.clearVotes();
        assertEquals(0, party.getAmountOfVotes());
    }

    @Test
    void nClearVotes(){
        party.clearVotes();
        party.addVote(new Vote(date));
        party.clearVotes();
        assertNotEquals(1, party.getAmountOfVotes());
    }

    @Test
    void pClearSeats(){
        party.clearSeats();
        party.addSeat(new Seat(date));
        party.clearSeats();
        assertEquals(0, party.getAmountOfSeats());
    }

    @Test
    void nClearSeats(){
        party.clearSeats();
        party.addSeat(new Seat(date));
        party.clearSeats();
        assertNotEquals(1, party.getAmountOfSeats());
    }

    @Test
    void pGetLastVoteDate(){
        party.clearVotes();
        party.addVote(new Vote(date));
        assertEquals(date, party.getLastVoteDate());
    }

    @Test
    void nGetLastVoteDate(){
        party.clearVotes();
        party.addVote(new Vote(date));
        assertNotEquals(date.plusDays(2), party.getLastVoteDate());
    }

    @Test
    void pGetLastSeatAssignedDate(){
        party.clearSeats();
        party.addSeat(new Seat(date));
        assertEquals(date, party.getLastSeatAssignedDate());
    }

    @Test
    void nGetLastSeatAssignedDate(){
        party.clearSeats();
        party.addSeat(new Seat(date));
        assertNotEquals(date.plusDays(2), party.getLastSeatAssignedDate());
    }

    @Test
    void pToString() {
        party.clearSeats();
        party.clearVotes();
        party.addSeat(new Seat(date));
        party.addVote(new Vote(date));
        String string = "List Number: " + listNr + "\nName: " + name + "\nVotes: " + 1 + "\nDate of Last Vote: " + date + "\nSeats: " + 1 + "\nDate of Last Seat Assigned: " + date;
        assertEquals(string, party.toString());
    }

    @Test
    void nToString() {
        party.clearSeats();
        party.clearVotes();
        party.addSeat(new Seat(date));
        party.addVote(new Vote(date));
        String string = "";
        assertNotEquals(string, party.toString());
    }
}