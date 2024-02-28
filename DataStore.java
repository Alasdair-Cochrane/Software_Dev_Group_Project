public interface DataStore {

    public void loadAll();
    public void readAll();

    public void addTeacher(Teacher t);
    public void addRequirement(Requirement r);
    public void addBooking(TrainingBooking tb);
    
}
