
package Application.Models.CSV;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Contracts.DataStorageInterface;

public final class Teacher implements DataStorageInterface<Teacher> {

    private final static String errorMessage = "Not instantiated or not in the database";
    private int id;
    private String name;
    private String speciality;
    private Database database = new Database(this);
    List<String> data = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String name, String specialisation) {
        this.name = name;
        this.speciality = specialisation;
    }

    public Teacher(int id, String name, String specialisation) {
        this.name = name;
        this.speciality = specialisation;
        this.id = id;
    }

    public int getId() {
        if (id == 0) {
            return 0;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if (this.name == null) {
            return errorMessage;
        }
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        if (this.speciality == null) {
            return errorMessage;
        }
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    private int setId() {
        int dbCount = database.count();
        if (dbCount == 0) {
            return this.id = 1;
        } else
            return ++dbCount;
    }

    private void prepareData() {
        if (this.getId() == 0) {
            // Auto incremenet
            this.id = this.setId();
        }
        data.add(String.valueOf(this.getId()));
        data.add(this.name);
        data.add(this.speciality);
    }

    @Override
    public Teacher get(int id) {
        List<String> result = database.retrieve(id);
        // only if the object exists in the database
        if (result != null) {
            return makeTeacher(result);
        }
        return this;
    }

    @Override
    public List<Teacher> getAll() {
        List<Teacher> teachersList = new ArrayList<>();
        List<List<String>> teachers = this.database.retrieveAll();
        for (List<String> list : teachers) {
            teachersList.add(makeTeacher(list));
        }
        if (teachersList.isEmpty()) {
            return null;
        } else
            return teachersList;
    }

    @Override
    public void save() {
        this.prepareData();
        database.add(data);

    }

    @Override
    public void update() {
        this.delete();
        this.save();
    }

    @Override
    public void delete() {
        if (this.getId() != 0) {
            database.delete(this.id);
        }
    }

    private Teacher makeTeacher(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);
        this.speciality = data.get(2);
        // Important as each instance will be different
        // This is a factory method
        return new Teacher(id, name, speciality);
    }

    // Keeping simple, this needs to be its own table if multiple allowed
    // public void addSpecialisation(String special) {
    // if (speciality == "") {
    // speciality = special;
    // return;
    // }
    // speciality += ", " + special;
    // }

}