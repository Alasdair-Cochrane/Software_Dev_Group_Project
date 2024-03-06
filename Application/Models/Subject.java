package Application.Models;

import java.util.ArrayList;
import java.util.List;

import Application.Models.CSV.Database;
import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Subject extends Data<Subject> implements DataStorageInterface<Subject> {

    private String name;
    private final static  Database database = new Database(Subject.class);

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    private Subject(List<String> data) {

        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);

        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void prepare() {
        if (this.getId() == 0) {
            // Auto incremenet
            this.id = this.setId();
        }
        data.add(String.valueOf(this.getId()));
        data.add(this.name);
    }

    public Subject get(int id) {
        List<String> result = database.retrieve(id);
        // only if the object exists in the database
        if (result != null) {
            return new Subject(result);
        }
        return this;
    }

    public List<Subject> getAll() {
        List<Subject> subjectList = new ArrayList<>();
        List<List<String>> subjects = database.retrieveAll();
        for (List<String> subject : subjects) {
            subjectList.add(new Subject(subject));
        }
        if (subjectList.isEmpty()) {
            return null;
        } else
            return subjectList;
    }

    @Override
    public void save() {
        this.prepare();
        database.add(data);
    }

    @Override
    public void update() {
        this.delete();
        database.add(data);
    }

    @Override
    public void delete() {
        if (this.getId() != 0) {
            database.delete(this.id);
        }
    }

}
