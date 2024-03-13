package Application.Views;

import java.util.List;

import Application.Controllers.Controller;
import Application.Models.Teacher;

public class ViewRequestsOperations {
	private static boolean isActive = true;

// For Course Director to request to add requirements
	protected static void requestAddRequirement(Controller controller) {
		System.out.println("You choosed to add requirement, please follow the instructions: ");
		int subjectID = Integer.parseInt(InputUtil.enterValue("Enter SubjectID: "));
		int hours = Integer.parseInt(InputUtil.enterValue("Enter required hours: "));
		int experience = Integer.parseInt(InputUtil.enterValue("Teacher's Experience: "));
		controller.addNewRequirement(subjectID, hours, experience);
	}

	// For both Course Director and administrator to request to add teacher
	protected static void requestAddTeacher(Controller controller) {
		System.out.println("You choosed add teacher option. For adding new teacher please specify teacher details: ");
		String name = InputUtil.enterValue("Teacher's name: ");
		int subjectID = Integer.parseInt(InputUtil.enterValue("Teacher's subject ID: "));
		int experience = Integer.parseInt(InputUtil.enterValue("Teacher's Experience: "));
		controller.addNewTeacher(name, subjectID, experience);
	}

//	For both Course Director and administrator to request to get all list of matched teachers
	protected static void requestGetListOfMachedTeachers(Controller controller) {
		System.out.println("List of matched teachers");
		String subjectID = InputUtil.enterValue("Enter SubjectID: ");
		List<Teacher> listOfMatchedTeachers = controller.matchTeacherWithRequirement(subjectID);
		int order = 1;
		for (Teacher teacher : listOfMatchedTeachers) {
			System.out.println(order++ + ". " + teacher.getName() + ". taught subject id is " + teacher.getSubjectId()
					+ " and has " + teacher.getExperience() + " years experience");
		}
	}
	
	protected static void BookTraining(Controller controller) {
		
		System.out.println("You choosed Booktraining by typing their name and ID and Experience: ");
		
		String name = InputUtil.enterValue("Teacher's name: ");
		
		int TeachersId = Integer.parseInt(InputUtil.enterValue("Teacher's ID: "));
	
		int subjectID = Integer.parseInt(InputUtil.enterValue("Teacher's subject ID: "));
		
		String Date = InputUtil.enterValue("Enter Date: ");
		
		
	   List<Teacher> getTeacherName = Teacher.getAll();
	   
	   Boolean matchFound = false;
	  
	   
	   for(Teacher teachers: getTeacherName) {
		   
			   if(teachers.getName().contains(name) && teachers.getId() == TeachersId ) { 
				   
					controller.addBookingToDatabase(TeachersId,subjectID,Date);
					matchFound = true;
					
					System.out.println("Training booked successfully for the following details:");
					System.out.println("Teacher's Name: " + name);
				    System.out.println("Teacher's ID: " + TeachersId);
				    System.out.println("Subject ID: " + subjectID);
				    System.out.println("Date: " + Date);
				    	   
			   }
		   
	   }
	   if(matchFound !=true) {
		   System.out.println("No Teacher found with this Details");
	   }
		
	
	}

//	Show Main manu that asks to enter your role
	protected static void MainMenu() {
		Controller controller = new Controller();
		String role = InputUtil.enterValue("What is your role: ").toLowerCase();

		if (role.equals("director")) {
			DirectorMenu.showDirectorMenuList(controller);

		} else if (role.equals("administrator")) {
			AdministratorMenu.showAdministratorMenuList(controller);
		}
	}

//	To close the app
	protected static void closeApp() {
		isActive = false;
		System.out.println("Application is closed");
	}

	protected static boolean isClosed() {
		return isActive;
	}

}
