package Application.Views;

import java.util.List;
import java.util.Scanner;

import Application.Controllers.Controller;
import Application.Models.Teacher;

public class Terminal {
	public static void main(String[] args) {
		Controller controller = new Controller();
		String role = enterValue("What is your role: ").toLowerCase();
		if (role.equals("director")) {
			showOperationOptionForDirector(controller);

		} else if (role.equals("administrator")) {
			showOperationoptionsForAdministrator(controller);
		}

	}

	private static void showOperationOptionForDirector(Controller controller) {

		System.out.println(menuListForDirector());
		int operation = Integer.parseInt(enterValue("Choose operation by selecting appropriate value: "));

		switch (operation) {
		case 1: {
			requestAddRequirement(controller);
			break;
		}
		case 2: {
			System.out.println("View list of all requirement");
//			controller.  => getAll method also should be implemented in the Controller class
			break;
		}
		case 3: {
			System.out.println("View list of all teachers");
//			controller we don't have method to get list of all teachers existed in our database;
			break;
		}
		case 4: {
			requestAddTeacher(controller);
			break;
		}
		case 5: {
			requestgetListOfMachedTeachers(controller);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}

	}

	private static void showOperationoptionsForAdministrator(Controller controller) {

		System.out.println(menuListForAdministrator());
		int operation = Integer.parseInt(enterValue("Choose operation by selecting appropriate value: "));

		switch (operation) {
		case 1: {
			System.out.println("View list of all requirement");
//			controller.  => getAll method also should be implemented in the Controller class
			break;
		}
		case 2: {
			System.out.println("View list of all teachers");
//			controller we don't have method to get list of all teachers existed in our database;
			break;
		}
		case 3: {
			requestAddTeacher(controller);
			break;
		}
		case 4: {
			requestgetListOfMachedTeachers(controller);
			break;
		}
		case 5: {
			System.out.println("Booking training");
//			controller => from controller object after getting al list of teachers you can choose them with their id or name
			controller.bookTraining(null);

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}
	}

	private static String menuListForDirector() {
		return ("Choose operation you want to execute: " + "\n1. Add requirement" + "\n2. View list of all requirement"
				+ "\n3. View list of all teachers" + "\n4. Add new teacher" + "\n5. List of macthed teachers");
	}

	private static String menuListForAdministrator() {
		return ("Choose operation you want to execute: " + "\n1. View list of all requirement"
				+ "\n2. View list of all teachers" + "\n3. Add new teacher" + "\n4. List of macthed teachers"
				+ "\n5.Booking training");
	}

	private static String enterValue(String message) {// method for the Scanner to get value from user
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		sc = new Scanner(System.in);
		return sc.nextLine();// value that is entered from terminal by user
	}

	private static void requestAddRequirement(Controller controller) {
		System.out.println("You choosed to add requirement, please follow the instructions: ");
		int subjectID = Integer.parseInt(enterValue("Enter SubjectID: "));
		int hours = Integer.parseInt(enterValue("Enter required hours: "));
		int experience = Integer.parseInt(enterValue("Teacher's Experience: "));
		controller.addNewRequirement(subjectID, hours, experience);
	}

	private static void requestAddTeacher(Controller controller) {
		System.out.println("You choosed add teacher option. For adding new teacher please specify teacher details: ");
		String name = enterValue("Teacher's name: ");
		int subjectID = Integer.parseInt(enterValue("Teacher's subject ID: "));
		int experience = Integer.parseInt(enterValue("Teacher's Experience: "));
		controller.addNewTeacher(name, subjectID, experience);
	}

	private static void requestgetListOfMachedTeachers(Controller controller) {
		System.out.println("List of matched teachers");
		String subjectID = enterValue("Enter SubjectID: ");
		List<Teacher> listOfMatchedTeachers = controller.matchTeacherWithRequirement(subjectID);
		int order = 1;
		for (Teacher teacher : listOfMatchedTeachers) {
			System.out.println(order++ + ". " + teacher.getName() + ". taught subject id is " + teacher.getSubjectId()
					+ " and has " + teacher.getExperience() + " years experience");
		}
	}
}
