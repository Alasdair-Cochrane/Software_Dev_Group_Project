package Application.Models.Contracts;


public interface DataStorageInterface<T> {
   //persists data of the created model
    public void save();

    //update the model
    public void update();

    // delete the retrieved object
    public void delete();


}
