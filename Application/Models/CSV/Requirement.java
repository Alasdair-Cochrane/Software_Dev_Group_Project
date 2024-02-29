package Application.Models.CSV;

import java.util.List;

import Application.Models.Contracts.DataStorageInterface;

public class Requirement implements DataStorageInterface<Requirement> {

    private int id;
    private String subject;
    private int hours;
    private int minimumExperience;
    private FileIO database;

    public Requirement(String subject, int numHours, int experience) {

        this.subject = subject;
        this.hours = numHours;
        this.minimumExperience = experience;
        this.database = new FileIO(this.getClass().getSimpleName());
    
    }

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


    public Requirement(int id, String subject, int numHours, int experience) {

        this.subject = subject;
        this.hours = numHours;
        this.minimumExperience = experience;
        this.id = id;
    }

    @Override
    public Requirement get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Requirement> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Requirement data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(Requirement data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}