package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Requirement;
import Application.Models.Teacher;

public class Controller {

	public Controller() {
	}

//called by the view
	public List<Teacher> matchTeacherWithRequirement(String input) {// it gives list of teachers which matches with the
																	// requirement id
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
		if (req.getSubjectId() == teacher.getSubjectId() && teacher.getExperience() >= req.getMinimumExperience()) {
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

	public void assignTeacher(Teacher teacher, Requirement requirement) {// assign teacher
		teacher.setRequriementId(requirement.getId());
		teacher.update();
	}

	public void bookTraining(Teacher teacher) {

	}

}