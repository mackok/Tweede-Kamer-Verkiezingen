package tests;

import app.Election;
import app.Party;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ElectionTest {
    private Party party = new Party(1, "De Partij");

    @Test
    void pGetParties() {
        Election election = new Election();
        election.addParty(party);
        ArrayList<Party> parties = new ArrayList<>();
        parties.add(party);
        assertEquals(parties, election.getParties());
    }

    @Test
    void nGetParties() {
        Election election = new Election();
        election.addParty(party);
        ArrayList<Party> parties = new ArrayList<>();
        parties.add(new Party(2, "Partij"));
        assertNotEquals(parties, election.getParties());
    }

    @Test
    void pGetParty() {
        Election election = new Election();
        election.addParty(party);
        assertEquals(party, election.getParty(1));
    }

    @Test
    void nGetParty(){
        Election election = new Election();
        election.addParty(party);
        assertNotEquals(party, election.getParty(2));
    }

    @Test
    void pAddParty() {
        Election election = new Election();
        election.addParty(party);
        assertEquals(party, election.getParty(1));
    }

    @Test
    void nAddParty(){
        Election election = new Election();
        election.addParty(party);
        assertNotEquals(new Party(2, "Partij"), election.getParty(1));
    }

    @Test
    void pAddVotesToParty() {
        Election election = new Election();
        party = new Party(1, "De Partij");
        election.addParty(party);
        election.addVotesToParty(1, 2);
        assertEquals(2, party.getAmountOfVotes());
    }

    @Test
    void nAddVotesToParty() {
        Election election = new Election();
        party = new Party(1, "De Partij");
        election.addParty(party);
        election.addVotesToParty(1, 2);
        assertNotEquals(0, party.getAmountOfVotes());
    }

    @Test
    void pDistributeSeats() {
        Election election = new Election();
        party = new Party(1, "De Partij");
        Party party2 = new Party(2, "Partij");
        election.addParty(party);
        election.addParty(party2);
        election.addVotesToParty(1, 20);
        election.addVotesToParty(2, 180);
        election.distributeSeats();
        assertEquals(135, party2.getAmountOfSeats());
    }

    @Test
    void nDistributeSeats() {
        Election election = new Election();
        party = new Party(1, "De Partij");
        Party party2 = new Party(2, "Partij");
        election.addParty(party);
        election.addParty(party2);
        election.addVotesToParty(1, 20);
        election.addVotesToParty(2, 180);
        election.distributeSeats();
        assertNotEquals(15, party2.getAmountOfSeats());
    }
}