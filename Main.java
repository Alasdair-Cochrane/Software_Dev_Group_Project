import Application.Models.CSV.Teacher;

public class Main {

    public static void main(String[] args) {     
        Teacher teacher = new Teacher("emran","test");
        teacher.save();
    }
}
