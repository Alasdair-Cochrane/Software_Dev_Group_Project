import Application.Models.CSV.Teacher;

public class Main {

    public static void main(String[] args) {     
        Teacher teacher = new Teacher("emran","test");
        teacher.save();
        teacher.get(1);
        System.out.println(teacher.getName());
        teacher.delete(6);
    }
}
