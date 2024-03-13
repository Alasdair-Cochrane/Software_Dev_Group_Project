package Application.Views;

import java.util.List;

import Application.Controllers.Controller;
import Application.Models.Requirement;
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
	
	protected static void displayBookedTraining(Controller controller) {
		System.out.println("You choosed Booktraining by typing the teachers ID and date: ");
		
		int teacherID = Integer.parseInt(InputUtil.enterValue("Enter teacher ID: "));
		String date = InputUtil.enterValue("Enter Date: ");
		
		
		List<Teacher> teachersInDatabase = controller.getAllTeachers();
		for (Teacher teacher: teachersInDatabase) {
			if (teacher.getId() == teacherID ) {
				controller.bookTraining(teacher.getId(), teacher.getSubjectId(), date);
				System.out.println("Training booked successfully for the following details:");
				System.out.println("Teacher's Name: " + teacher.getName());
			    System.out.println("Teacher's ID: " + teacher.getId());
			    System.out.println("Subject ID: " + teacher.getSubjectId());
			    System.out.println("Date: " + date);
				return;
			}
		}
		System.out.println("Unable to book training. Teacher not found");			
	}
	
	 public static void displayTeachingRequirements(Controller controller) {
		    List<Requirement> requirements = controller.getAllRequirement();

		    if (requirements != null && !requirements.isEmpty()) {
		      System.out.println("Teaching Requirements for the Upcoming Term/Semester:");
		      for (Requirement requirement : requirements) {
		        displayTeachingRequirement(requirement);
		      }
		    } else {
		      System.out.println("No teaching requirements available for the upcoming term/semester.");
		    }
		  }

		  private static void displayTeachingRequirement(Requirement requirement) {
		    System.out.println("Subject ID: " + requirement.getSubjectId() + " | Hours: " + requirement.getHours()
		        + " |Minimum Experience: " + requirement.getMinimumExperience());

		  }

		  // Display teachers
		  public static void displayTeachers(Controller ccontroller) {
		    List<Teacher> teachers = Controller.getAllTeachers();

		    if (teachers != null && !teachers.isEmpty()) {
		      System.out.println("The available teachers Upcoming Term/Semester:");
		      for (Teacher teacher : teachers) {
		        displayTeachers(teacher);
		      }
		    } else {
		      System.out.println("No available teachers");
		    }
		  }

		  private static void displayTeachers(Teacher teachers) {
		    System.out.println("Name: " + teachers.getName() + " |Experience: " + teachers.getExperience() + "|Subject id" + teachers.getSubjectId() + " teacher Id" + teachers.getId());

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
