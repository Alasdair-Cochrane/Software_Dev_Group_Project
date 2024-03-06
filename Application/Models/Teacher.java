
package Application.Models;

import java.util.ArrayList;
import java.util.List;

import Application.Models.CSV.Database;
import Application.Models.Contracts.Data;
import Application.Models.Contracts.DataStorageInterface;

public final class Teacher extends Data<Teacher> implements DataStorageInterface<Teacher> {

  private String name;
  private int subjectId;
  private int experience;
  // nullable foreign key
  private int requriementId = 0;
  private final static  Database database = new Database(Teacher.class);

  public Teacher() {
  }

  private Teacher(List<String> data) {
    
    this.id = Integer.parseInt(data.get(0));
    this.name = data.get(1);
    this.subjectId = Integer.parseInt(data.get(2));
    this.experience = Integer.parseInt(data.get(3));
    this.requriementId = Integer.parseInt(data.get(4));
  }

  public Teacher(String name, int subjectId, int experience) {
    this.name = name;
    this.subjectId = subjectId;
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

  public int getRequriementId() {
    return requriementId;
  }

  public void setRequriementId(int requriementId) {
    this.requriementId = requriementId;
  }

   protected void prepare() {
    if (this.getId() == 0) {
      // Auto incremenet
      this.id = this.setId();
    }
    data.add(String.valueOf(this.getId()));
    data.add(this.name);
    data.add(String.valueOf(this.subjectId));
    data.add(String.valueOf(this.experience));
    data.add(String.valueOf(this.requriementId));
  }

  public static Teacher get(int id) {
    List<String> result = database.retrieve(id);
    // only if the object exists in the database
    if (result != null) {
      return new Teacher(result);
    }
    return null;
  }

  public static  List<Teacher> getAll() {
    List<Teacher> teachersList = new ArrayList<>();
    List<List<String>> teachers = database.retrieveAll();
    for (List<String> teacher : teachers) {
      teachersList.add(new Teacher(teacher));
    }
    if (teachersList.isEmpty()) {
      return null;
    } else
      return teachersList;
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
