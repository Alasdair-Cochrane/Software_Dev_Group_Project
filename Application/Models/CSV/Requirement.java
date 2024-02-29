package Application.

public class Requirement {

    private static int idCounter;
    private int id;
    private String subject;
    private int hours;
    private int minimumExperience;

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getHours() {
        return hours;
    }

    public int getMinimumExperience() {
        return minimumExperience;
    }

    public Requirement(String subject, int numHours, int experience) {

        this.subject = subject;
        this.hours = numHours;
        this.minimumExperience = experience;
        this.id = idCounter++;
    }

    public Requirement(int id, String subject, int numHours, int experience) {

        this.subject = subject;
        this.hours = numHours;
        this.minimumExperience = experience;
        this.id = id;
    }

}
