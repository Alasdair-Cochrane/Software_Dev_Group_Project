package Application.Models.CSV;

import java.util.Date;

public class Booking {

    private Date date;
    private int teacherID;
    private String trainingSubject;

    public Date getDate() {
        return date;
    }

    public int getTeacher() {
        return teacherID;
    }

    public String getTrainingSubject() {
        return trainingSubject;
    }

    public Booking(Date date, int teach, String subject) {
        this.date = date;
        this.teacherID = teach;
        this.trainingSubject = subject;
    }

}
