package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.*;

public class Controller {

 

  public Controller() {
  }

  public List<Teacher> matchTeacherWithRequirement(String input) {
    int inputSubjectID = Integer.parseInt(input);
    List<Requirement> requirements = Requirement.getAll();

    for (Requirement r : requirements) {
      if (r.getSubjectId() == inputSubjectID) {
        return findAvailableTeacher(r);
      }
    }
    return new ArrayList<Teacher>();
  }

  private List<Teacher> findAvailableTeacher(Requirement req) {
    List<Teacher> availableTeachers = new ArrayList<>();
    List<Teacher> teachers = Teacher.getAll();

    for (Teacher teacher : teachers) {
      if (teacherMeetsRequirements(teacher, req)) {
        availableTeachers.add(teacher);
      }
    }
    return availableTeachers;
  }

  private boolean teacherMeetsRequirements(Teacher teacher, Requirement req) {
    if (req.getSubjectId() == teacher.getSubjectId() &&
        teacher.getExperience() >= req.getMinimumExperience()) {
      return true;

    }
    return false;
  }

  public void addNewTeacher(String name, int subjectId, int experience) {
    Teacher t = new Teacher(name, subjectId, experience);
    t.save();
  }

  public void addNewRequirement(int subject, int hours, int experience) {
    Requirement r = new Requirement(subject, hours, experience);
    r.save();
  }

  public void assignTeacher(Teacher teacher, Requirement requirement) {
    teacher.setRequriementId(requirement.getId());
    teacher.update();
  }

  
  public void bookTraining(int teacherId, int subjectId, String date) {
      Booking newBooking = new Booking(teacherId, subjectId, date);
      newBooking.save();
  }

  public  List<Requirement> getAllRequirement() {
    return Requirement.getAll();
  }

  public List<Teacher> getAllTeachers() {
    return Teacher.getAll();
  }

}
