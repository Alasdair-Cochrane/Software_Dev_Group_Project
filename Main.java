import Application.Models.CSV.Teacher;

public class Main {

    public static void main(String[] args) {     
        // Teacher teacher = new Teacher("emran","test");
        // Teacher teacher1 = new Teacher("james","test");
        // Teacher teacher2 = new Teacher("bob","test");
        // teacher.save();
        // teacher1.save();
        // teacher2.save();
        // teacher.get(1);
        // System.out.println(teacher.getName());
        Teacher teacher = new Teacher();
        Teacher emran = teacher.get(7);
        Teacher james = teacher.get(12);
        james.setName("bob");
        emran.setName("alex");
        emran.update();
        james.save();


    }
}
