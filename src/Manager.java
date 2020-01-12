import java.util.Collection;

public abstract class Manager {
    private Collection<Assignable> collection;

    public Manager(Collection<Assignable> collection){
        this.collection = collection;
    }

    protected abstract void distribute();

    public Collection<Assignable> getCollection(){
        return collection;
    }

    public void addToCollection(Assignable item){
        collection.add(item);
    }

    public int getNumberOfAssignables(){
        return collection.size();
    }
}
