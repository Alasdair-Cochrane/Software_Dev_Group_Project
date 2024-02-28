import java.util.List;

public interface DataStore {

    public Boolean addTeacher(Teacher t);
    public Boolean addRequirement(Requirement r);
    public Boolean addBooking(TrainingBooking tb);

    public Boolean removeTeacher(Teacher t);
    public Boolean remoteRequirement(Requirement r);
    public Boolean removeBooking(TrainingBooking b);

    public List<Teacher> getAllTeachers();
    public List<Requirement> getAllRequirements();
    public List<TrainingBooking> getAllBookings();

    public Teacher getTeacherByid(int id);
    public Requirement getRequirementByID(int id);
    public TrainingBooking getBookingByID(int id);
    
}
