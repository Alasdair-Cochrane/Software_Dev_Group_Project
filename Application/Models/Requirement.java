package Application.Models;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Requirement extends Data<Requirement> implements DataStorageInterface<Requirement> {

    private int subjectId;
    private int hours;
    private int minimumExperience;

    public Requirement() {
    }

    public Requirement(int subjectId, int numHours, int experience) {

        this.subjectId = subjectId;
        this.hours = numHours;
        this.minimumExperience = experience;

    }

    private Requirement(int id, int subjectId, int numHours, int experience) {
        this.id = id;
        this.subjectId = subjectId;
        this.hours = numHours;
        this.minimumExperience = experience;

    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectID(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinimumExperience() {
        return minimumExperience;
    }

    public void setMinimumExperience(int minimumExperience) {
        this.minimumExperience = minimumExperience;
    }

    private Requirement makRequirement(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.subjectId = Integer.parseInt(data.get(1));
        this.hours = Integer.parseInt(data.get(2));
        this.minimumExperience = Integer.parseInt(data.get(3));
        // Important as each instance will be different
        // This is a factory method
        return new Requirement(this.id, this.subjectId, this.hours, this.minimumExperience);
    }

    private void prepareData() {
        if (this.getId() == 0) {
            // Auto incremenet
            this.id = this.setId();
        }
        data.add(String.valueOf(this.getId()));
        data.add(String.valueOf(this.getSubjectId()));
        data.add(String.valueOf(this.getHours()));
        data.add(String.valueOf(this.getMinimumExperience()));
    }

    @Override
    public Requirement get(int id) {
        List<String> result = database.retrieve(id);
        // only if the object exists in the database
        if (result != null) {
            return makRequirement(result);
        }
        return this;
    }

    @Override
    public List<Requirement> getAll() {
        List<Requirement> requirementList = new ArrayList<>();
        List<List<String>> requirements = this.database.retrieveAll();
        for (List<String> requirment : requirements) {
            requirementList.add(makRequirement(requirment));
        }
        if (requirementList.isEmpty()) {
            return null;
        } else
            return requirementList;
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

}