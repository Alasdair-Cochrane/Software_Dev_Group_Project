package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.*;
import Application.Models.Requirement;
import Application.Models.Booking;

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
	List<Teacher> availableTeachers = new ArrayList<>();
    	
    	for(Teacher teacher: teachers) {
    		if(teacherMeetsRequirements(teacher, req)) {
    			availableTeachers.add(teacher);
    		}
    		
    	}
        return availableTeachers;
    }
    
    private boolean teacherMeetsRequirements(Teacher teacher, Requirement req) {
    	boolean meetsSubject = teacher.getSpeciality().contains(req.getSubject());
    	boolean meetsExperience = teacher.getExperience() >= req.getMinimumExperience();
    	 return meetsSubject && meetsExperience; 	
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
