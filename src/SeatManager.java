import java.util.ArrayList;

public class SeatManager extends Manager {
    private static final int amountOfSeats = 150;
    private ArrayList<Seat> remainderSeats;
    private float quota;

    public SeatManager(ArrayList<Assignable> seats) {
        super(seats);
        quota = 0;
    }

    public ArrayList<Seat> getRemainderSeats() {
        return remainderSeats;
    }

    public int getNumberOfRemainderSeats(){
        return remainderSeats.size();
    }

    public float getQuota(int totalVotes){
        calculateQuota(totalVotes);
        return quota;
    }

    public void addRemainderSeats(int amount, int listNumber){

    }

    @Override
    protected void distribute() {

    }

    private void distributeRemainderSeats(){

    }

    private void calculateQuota(int totalVotes){
        quota = totalVotes / amountOfSeats;
    }
}
