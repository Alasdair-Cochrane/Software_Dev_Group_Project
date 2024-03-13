package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.*;

public class Controller {
  
  public Controller() {
  }

  public List<Teacher> matchTeacherWithRequirement(int subjectID) {
    List<Requirement> requirements = Requirement.getAll();

    for (Requirement r : requirements) {
      if (r.getSubjectId() == subjectID) {
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

  public void bookTraining(Teacher teacher) {

    if (teacher != null) {
      System.out.println("Training booked for teacher " + teacher.getName() +
          " for subject ID: " + teacher.getSubjectId() +
          " with experience requirement: " + teacher.getExperience());
    } else {
      System.out.println("Unable to book training. Teacher not found");
    }
  }

  public List<Requirement> getAllRequirements() {
    return Requirement.getAll();
  }

  public List<Teacher> getAllTeachers() {
    return Teacher.getAll();
  }
  
  public void addBookingToDatabase(int teacherId, int subjectId, String date) {
    Booking newBooking = new Booking(teacherId, subjectId, date);
    newBooking.save();
}

}
