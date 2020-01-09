public class Party {
    private int listNumber;
    private String name;

    public Party(int listNumber, String name){
        this.listNumber = listNumber;
        this.name = name;
    }

    public int getListNumber(){
        return listNumber;
    }

    public String getName() {
        return name;
    }
}
