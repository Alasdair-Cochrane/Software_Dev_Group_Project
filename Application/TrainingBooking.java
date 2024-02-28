package Application;
import java.util.Date;

public class TrainingBooking {

    private Date date;
    private Teacher teacher;
    private String trainingSubject;

    public Date getDate(){return date;}
    public Teacher getTeacher(){return teacher;}
    public String getTrainingSubject(){return trainingSubject;}

    public TrainingBooking (Date date, Teacher teach, String subject){
        this.date = date;
        this.teacher = teach;
        this.trainingSubject = subject;
    }
    
}
