package Application.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Models.*;
import Application.Models.Requirement;
import Application.Models.Booking;

public class Controller {
        Teacher teacher;
        Requirement requirement;
        Booking booking;
        Subject subject;

    public Controller() {
        teacher = new Teacher();
        requirement = new Requirement();
        booking = new Booking();
        subject = new Subject();
    }

//called by the view
    public List<Teacher> matchTeacherWithRequirement(String input){
        int inputSubjectID = Integer.parseInt(input);   
        List<Requirement> requirements = requirement.getAll();     

        for(Requirement r : requirements){
            if(r.getSubjectId() == inputSubjectID){
                return findAvailableTeacher(r);
            }
        }
        return new ArrayList<Teacher>();
    }


    private List<Teacher> findAvailableTeacher(Requirement req) {
        List<Teacher> availableTeachers; 
        Teacher teacherModel = new Teacher();
        List<Teacher> teachers = teacherModel.getAll();
    	
    	for(Teacher teacher: teachers) {
    		if(teacherMeetsRequirements(teacher, req)) {
    			availableTeachers.add(teacher);
    		}    		
    	}
        return availableTeachers;
    }
    
    private boolean teacherMeetsRequirements(Teacher teacher, Requirement req) {
        if (req.getSubjectId() == teacher.getSubjectId() &&
            teacher.getExperience() >= req.getMinimumExperience()){
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
       //     teacher.setRequirementID(integer)
    }

    public void bookTraining(Teacher teacher) {

    }

}
