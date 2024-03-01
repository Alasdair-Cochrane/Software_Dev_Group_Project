package Application.Models;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Subject extends Data<Subject> implements DataStorageInterface<Subject> {

    private String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    private Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Subject makSubject(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);
        // Important as each instance will be different
        // This is a factory method
        return new Subject(this.id, this.name);
    }

    private void prepareData() {
        if (this.getId() == 0) {
            // Auto incremenet
            this.id = this.setId();
        }
        data.add(String.valueOf(this.getId()));
        data.add(this.name);
    }

    @Override
    public Subject get(int id) {
        List<String> result = database.retrieve(id);
        // only if the object exists in the database
        if (result != null) {
            return makSubject(result);
        }
        return this;
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjectList = new ArrayList<>();
        List<List<String>> subjects = this.database.retrieveAll();
        for (List<String> subject : subjects) {
            subjectList.add(makSubject(subject));
        }
        if (subjectList.isEmpty()) {
            return null;
        } else
            return subjectList;
    }

    @Override
    public void save() {
        this.delete();
        this.save();
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {
        if (this.getId() != 0) {
            database.delete(this.id);
        }
    }

}
