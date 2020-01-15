import java.util.ArrayList;

public class Election {
    private ArrayList<Party> parties;
    private static final int amountOfSeats = 150;
    private double quota;

    public Election(){
        parties = new ArrayList<>();
        quota = 0;
    }

    public ArrayList<Party> getParties() {
        return parties;
    }

    public Party getParty(int listNumber){
        Party result;

        try{
            result = parties.get(listNumber-1);
        }
        catch (IndexOutOfBoundsException e){
            result = null;
        }

        return result;
    }

    public int getNumberOfPartyVotes(Party party){
        return party.getAmountOfVotes();
    }

    public int getNumberOfPartySeats(Party party){
        return party.getAmountOfSeats();
    }

    public void addParty(Party party){
        parties.add(party);
    }

    public void addVotesToParty(int listNr, int amount){
        Party party = getParty(listNr);
        for(int i = amount; i > 0; i--){
            party.addVote(new Vote());
        }
    }

    private void addSeatsToParty(Party party, int amount){
        for(int i = amount; i > 0; i--){
            party.addSeat(new Seat());
        }
    }

    public void distributeSeats(){
        int totalVotes = 0;
        for(Party party : parties){
            totalVotes += party.getAmountOfVotes();
        }
        calculateQuota(totalVotes);
        assignSeats();
        assignRemainderSeats();
    }

    private void assignSeats(){
        for(Party party : parties){
            int amount = (int)Math.floor(party.getAmountOfVotes() / quota);
            addSeatsToParty(party, amount);
        }
    }

    private void assignRemainderSeats(){
        int totalSeats = 0;
        for(Party party : parties){
            totalSeats += party.getAmountOfSeats();
        }
        int amountRemaining = amountOfSeats - totalSeats;
        for(int i = amountRemaining; i > 0; i--){
            Party party = getPartyWithMostVotesPerSeat();
            party.addSeat(new Seat());
        }
    }

    private Party getPartyWithMostVotesPerSeat(){
        Party mostVotesPerSeat = null;

        double mostAmountOfVotesPerSeat = 0;
        for(Party party : parties){
            double amountOfVotesPerSeat = party.getAmountOfVotes() / (party.getAmountOfSeats()+1);
            if(amountOfVotesPerSeat > mostAmountOfVotesPerSeat){
                mostAmountOfVotesPerSeat = amountOfVotesPerSeat;
                mostVotesPerSeat = party;
            }
        }

        return mostVotesPerSeat;
    }

    private void calculateQuota(int totalVotes){
        quota = (double)totalVotes / (double)amountOfSeats;
    }
}
