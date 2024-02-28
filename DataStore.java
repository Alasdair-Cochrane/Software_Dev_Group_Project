import java.util.List;

public interface DataStore {

    public Boolean addTeacher(Teacher t);
    public Boolean addRequirement(Requirement r);
    public Boolean addBooking(Booking tb);

    public Boolean removeTeacher(Teacher t);
    public Boolean remoteRequirement(Requirement r);
    public Boolean removeBooking(Booking b);

    public List<Teacher> getAllTeachers();
    public List<Requirement> getAllRequirements();
    public List<Booking> getAllBookings();

    
}
