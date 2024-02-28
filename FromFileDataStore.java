import java.util.ArrayList;
import java.util.List;

public class FromFileDataStore implements DataStore{

    public List<Teacher> teachers;
    public List<Requirement> requirements;
    public List<TrainingBooking> bookings;


    

    public FromFileDataStore(){
        teachers = new ArrayList<>();
        requirements = new ArrayList<>();
        bookings = new ArrayList<>();
    }




    @Override
    public void loadAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadAll'");
    }
    @Override
    public void readAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }
    @Override
    public void addTeacher(Teacher t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTeacher'");
    }
    @Override
    public void addRequirement(Requirement r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRequirement'");
    }
    @Override
    public void addBooking(TrainingBooking tb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBooking'");
    }
    

    
}
