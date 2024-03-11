package Application.Models;

import java.util.ArrayList;
import java.util.List;

import Application.Models.CSV.Database;
import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Requirement extends Data<Requirement> implements DataStorageInterface<Requirement> {

  private int subjectId;
  private int hours;
  private int minimumExperience;
  private final static Database database = new Database(Requirement.class);

  public Requirement() {
  }

  public Requirement(int subjectId, int numHours, int experience) {

    this.subjectId = subjectId;
    this.hours = numHours;
    this.minimumExperience = experience;

  }

  private Requirement(List<String> data) {

    this.id = Integer.parseInt(data.get(0));
    this.subjectId = Integer.parseInt(data.get(1));
    this.hours = Integer.parseInt(data.get(2));
    this.minimumExperience = Integer.parseInt(data.get(3));
  }

  protected int setId() {
    int dbCount = database.count();
    if (dbCount == 0) {
      return this.id = 1;
    } else
      return ++dbCount;
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

  protected void prepare() {
    if (this.getId() == 0) {
      // Auto incremenet
      this.id = this.setId();
    }
    data.add(String.valueOf(this.getId()));
    data.add(String.valueOf(this.getSubjectId()));
    data.add(String.valueOf(this.getHours()));
    data.add(String.valueOf(this.getMinimumExperience()));
  }

  public Requirement get(int id) {
    List<String> result = database.retrieve(id);
    // only if the object exists in the database
    if (result != null) {
      return new Requirement(result);
    }
    return this;
  }

  public static List<Requirement> getAll() {
    List<Requirement> requirementList = new ArrayList<>();
    List<List<String>> requirements = database.retrieveAll();
    for (List<String> requirement : requirements) {
      requirementList.add(new Requirement(requirement));
    }
    if (requirementList.isEmpty()) {
      return null;
    } else
      return requirementList;
  }

  @Override
  public void save() {
    this.prepare();
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
