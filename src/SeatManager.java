import java.util.ArrayList;

public class SeatManager extends Manager {
    private ArrayList<Seat> remainderSeats;
    private float quota;

    public SeatManager(ArrayList<Assignable> seats) {
        super(seats);
    }

    public ArrayList<Seat> getRemainderSeats() {
        return remainderSeats;
    }

    public int getNumberOfRemainderSeats(){
        return remainderSeats.size();
    }

    public float getQuota(){
        return quota;
    }

    public void addRemainderSeats(int amount, int listNumber){

    }

    @Override
    protected void distribute() {

    }

    private void distributeRemainderSeats(){

    }

    private float calculateQuota(){
        return 0; //placeholder
    }
}
