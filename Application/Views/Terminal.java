package Application.Views;
import Application.Models.CSV.*;

import java.util.List;

import Application.Models.Requirement;
import Application.Models.Booking;
import Application.Models.Teacher;

public class Terminal {
	//display teaching requirements
	public void displayTeachingRequirements(Requirement teachingRequirements) {
        List<Requirement> requirements = teachingRequirements.getAll();

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
	        System.out.println("Subject ID: " + requirement.getSubjectId());
	        System.out.println("Hours: " + requirement.getHours());
	        System.out.println("Minimum Experience: " + requirement.getMinimumExperience());
	        System.out.println();
	    }

	 //Display bookings
	 public void displayBookings(Booking teachingBookings) {
		 List <Booking> bookings = teachingBookings.getAll();
	        if (bookings != null && !bookings.isEmpty()) {
	            System.out.println("Bookings:");
	            for (Booking booking : bookings) {
	                displayBooking(booking);
	            }
	        } else {
	            System.out.println("No bookings available.");
	        }
	    }
	 	private void displayBooking(Booking booking) {
	        System.out.println("Booking ID: " + booking.getId());
	        System.out.println("Teacher ID: " + booking.getTeacherId());
	        System.out.println("Subject ID: " + booking.getSubjectId());
	        System.out.println("Date: " + booking.getDate());
	        System.out.println();
	    }
	 	
	 	//display Teachers available
 	public void displayTeachers(Teacher availableTeachers) {
 		List <Teacher> teachers = availableTeachers.getAll();
 		
 		if (teachers != null && teachers.isEmpty()) {
 			System.out.println("Teachers");
 			for (Teacher teacher: teachers) {
 				displayTeacher(teacher);
 			}	
 		}else {
 			System.out.println("No teachers available");
 		}
 	
 	}
 	private void displayTeacher(Teacher teachers) {
        System.out.println("Teacher ID: " + teachers.getId());
        System.out.println("Teacher Name: " + teachers.getName());
        System.out.println("Subject ID: " + teachers.getSubjectId());
        System.out.println("Experience: " + teachers.getExperience());
        System.out.println();
    }
	  
}
