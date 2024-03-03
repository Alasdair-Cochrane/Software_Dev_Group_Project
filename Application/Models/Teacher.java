
package Application.Models;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Teacher extends Data<Teacher> implements DataStorageInterface<Teacher> {

    private String name;
    private int subjectId;
    private int experience;

    public Teacher() {
    }

    public Teacher(String name, int subjectId, int experience) {
        this.name = name;
        this.subjectId = subjectId;
        this.experience = experience;
    }

    private Teacher(int id, String name, int subjectId, int experience) {
        this.name = name;
        this.subjectId = subjectId;
        this.id = id;
        this.experience = experience;
    }

    public int getExperience() {
        if (this.experience == 0) {
            System.err.println("no experience has been allocated");
            return 0;
        }
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public int getSubjectId() {
        if (this.subjectId == 0) {
            System.err.println("No subject has been associated yet");
            return 0;
        }
        return this.subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    private Teacher makeTeacher(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);
        this.subjectId = Integer.parseInt(data.get(2));
        this.experience = Integer.parseInt(data.get(3));
        // Important as each instance will be different
        // This is a factory method
        return new Teacher(this.id, this.name, this.subjectId,this.experience);

    }

    private void prepareData() {
        if (this.getId() == 0) {
            // Auto incremenet
            this.id = this.setId();
        }
        data.add(String.valueOf(this.getId()));
        data.add(this.name);
        data.add(String.valueOf(this.subjectId));
        data.add(String.valueOf(this.experience));
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
        for (List<String> teacher : teachers) {
            teachersList.add(makeTeacher(teacher));
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

    // Keeping simple, this needs to be its own table if multiple allowed
    // public void addSpecialisation(String special) {
    // if (speciality == "") {
    // speciality = special;
    // return;
    // }
    // speciality += ", " + special;
    // }

}