import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FromFileDataStore implements DataStore{

    private String filePath;
    public void setFilePath(String path){filePath = path;}

    private List<Teacher> teachers;
    private List<Requirement> requirements;
    private List<TrainingBooking> bookings;

    AppDataReader reader;
    AppDataWriter writer;

    public List<Teacher> getAllTeachers() {return teachers;}
    public List<Requirement> getAllRequirements() {return requirements;}
    public List<TrainingBooking> getAllBookings() {return bookings;}


    public Boolean validateFilePath(){
        try (FileReader fr = new FileReader(filePath)) {
            return true;            
        } catch (IOException e) {
            return false;
        }
    }


    public void loadAll() {
        

    }

    public void writeAll() {

    }

    @Override
    public Boolean addTeacher(Teacher t) {
        if(!teachers.contains(t)){
            teachers.add(t);
            return true;
          }
          return false;                
    }

    @Override
    public Boolean addRequirement(Requirement r) {
        if(!requirements.contains(r)){
            requirements.add(r);
            return true;
        }
        return false;
    }
    @Override
    public Boolean addBooking(TrainingBooking tb) {
        if(!bookings.contains(tb)){
            bookings.add(tb);
            return true;
        }
        return false;
    }


    @Override
    public Boolean removeTeacher(Teacher t) {
      if(teachers.contains(t)){
        teachers.remove(t);
        return true;
      }
      return false;        
    }


    public Boolean remoteRequirement(Requirement r) {
        if(requirements.contains(r)){
            requirements.remove(r);
            return true;
        }
        return false;
    }

    public Boolean removeBooking(TrainingBooking b) {
        if(bookings.contains(b)){
            bookings.remove(b);
            return true;
        }
        return false;
    }

//uses default file reader that we created
    public FromFileDataStore(AppDataReader reader, AppDataWriter writer){
        teachers = new ArrayList<>();
        requirements = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    public FromFileDataStore(String filepath){
        teachers = new ArrayList<>();
        requirements = new ArrayList<>();
        bookings = new ArrayList<>();

        reader = new CSVReader(filePath);
        writer = new CSVWriter(filePath);
    }
    @Override
    public Teacher getTeacherByid(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeacherByid'");
    }
    @Override
    public Requirement getRequirementByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRequirementByID'");
    }
    @Override
    public TrainingBooking getBookingByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingByID'");
    }
    

    
}
