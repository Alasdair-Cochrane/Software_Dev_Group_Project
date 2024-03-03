package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.Booking;
import Application.Models.Requirement;
import Application.Models.Teacher;

public class ApplicationMain {

	public List<Teacher> teachers;
	public List<Requirement> requirements;
	public List<Booking> bookings;

	public ApplicationMain() {
		teachers = new ArrayList<>();
		requirements = new ArrayList<>();
		bookings = new ArrayList<>();
	}

	public List<Teacher> findAvailableTeacher(Requirement req) {
		return null;
	}

	public void addNewTeacher() {

	}

	public void addNewRequirement() {

	}

	public void assignTeacher(Teacher teacher, Requirement requirement) {

	}

	public void organiseTraining(Teacher teacher) {

	}

}
