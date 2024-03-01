import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.List;

import Application.Models.Booking;
import Application.Models.Requirement;
import Application.Models.Subject;
import Application.Models.Teacher;
import Application.Models.Contracts.DataStorageInterface;

public class Main {

    public static void main(String[] args) {
        List<DataStorageInterface> tables = new ArrayList<>();

        // The databases are automatically created if they do not exists in
        // Database/FileSystem/ path
        // the path is not created

        // 1. Creating Objects using constructors
        Teacher teacher3 = new Teacher("emran", "test");
        Teacher teacher1 = new Teacher("james", "test");
        Teacher teacher2 = new Teacher("bob", "test");

        Subject subject = new Subject("chemistry");
        Subject subject2 = new Subject("Biology");
        Subject subject3 = new Subject("Crap");

        Requirement requirement = new Requirement(1, 2, 3);
        Requirement requirement1 = new Requirement(2, 3, 4);
        Requirement requirement2 = new Requirement(7, 6, 4);

        Booking booking = new Booking(1, 2, "11-22-3333");
        Booking booking1 = new Booking(1, 2, "11-22-4444");
        Booking booking2 = new Booking(1, 2, "11-22-4444");

        tables.add(teacher3);
        tables.add(teacher1);
        tables.add(teacher2);

        tables.add(booking);
        tables.add(booking1);
        tables.add(booking2);

        tables.add(subject);
        tables.add(subject2);
        tables.add(subject3);

        tables.add(requirement);
        tables.add(requirement1);
        tables.add(requirement2);

        // to Save you call save() method
        for (DataStorageInterface<?> table : tables) {
            table.save();
        }

        // 2. Creating Objects using getter setter
        Teacher alex = new Teacher();
        // ID is optional
        // We might better off deleting
        alex.setId(20);
        alex.setName("alex");
        alex.setSpeciality("waste of life");
        alex.save();

        // 3. getting all
        Teacher teacher = new Teacher();
        // In the database version it will be static
        List<Teacher> teachers = teacher.getAll();
        for (Teacher t : teachers) {
            System.out.println(t.getName());
        }

        // 4. getting and deleting
        // first get the teacher
        // then call delete
        // I can overload if you want, but makes no sense in this desing
        // each object is individual person
        // For real application with database this will be static
        Teacher james = teacher.get(3);
        james.delete();

        // 5. Preferebly would like a static delete(int id) as well
        // This will not work because we are not working with database
        // the files need to be read and written to after change

        // 6. Getting the Object attributes
        // once retireved you can get the details
        Subject biology = new Subject().get(2);
        biology.getId();
        biology.getName();

        // 7. Updating
        // you get the object
        // use setters to update
        // then use update() to update
        biology.setName("math");
        biology.update();

    }
}
