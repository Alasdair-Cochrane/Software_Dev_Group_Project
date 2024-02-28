import java.util.Date;

public class TrainingBooking {

    private Date date;
    private int teacherID;
    private String trainingSubject;

    public Date getDate(){return date;}
    public int getTeacher(){return teacherID;}
    public String getTrainingSubject(){return trainingSubject;}

    public TrainingBooking (Date date, int teach, String subject){
        this.date = date;
        this.teacherID = teach;
        this.trainingSubject = subject;
    }
    
}
