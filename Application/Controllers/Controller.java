package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.*;

public class Controller {
	

  private Requirement r;
  private Teacher t;

  public Controller() {
  }

  // called by the view
  // display teaching requirements
  public void displayTeachingRequirements() {
    List<Requirement> requirements = Requirement.getAll();

    if (requirements != null && !requirements.isEmpty()) {
      System.out.println("Teaching Requirements for the Upcoming Term/Semester:");
      for (Requirement requirement : requirements) {
        displayTeachingRequirement(requirement);
      }
    } else {
      System.out.println("No teaching requirements available for the upcoming term/semester.");
    }
  }

  private void displayTeachingRequirement(Requirement requirement) {
    System.out.println("Subject ID: " + requirement.getSubjectId() + " | Hours: " + requirement.getHours()
        + " |Minimum Experience: " + requirement.getMinimumExperience());

  }

  // Display teachers
  public void displayTeachers() {
    List<Teacher> teachers = Teacher.getAll();

    if (teachers != null && !teachers.isEmpty()) {
      System.out.println("The available teachers Upcoming Term/Semester:");
      for (Teacher teacher : teachers) {
        displayTeachers(teacher);
      }
    } else {
      System.out.println("No available teachers");
    }
  }

  private void displayTeachers(Teacher teachers) {
    System.out.println("Name: " + teachers.getName() + " |Experience: " + teachers.getExperience());

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

  public void bookTraining(Teacher teacher) {

    if (teacher != null) {
      System.out.println("Training booked for teacher " + teacher.getName() +
          " for subject ID: " + teacher.getSubjectId() +
          " with experience requirement: " + teacher.getExperience());
    } else {
      System.out.println("Unable to book training. Teacher not found");
    }

    public void bookTraining(Teacher teacher) {

    }
    
    public static List<Requirement> getAllRequirement(){
    	return Requirement.getAll(); 	
    }
    public static List<Teacher> getAllTeachers(){
    	return Teacher.getAll(); 	
    }

}
