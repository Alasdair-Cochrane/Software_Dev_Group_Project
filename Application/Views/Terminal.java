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
			System.out.println(menuListForDirector());
			int operation = Integer.parseInt(enterValue("Enter operation value: "));

			switch (operation) {
			case 1: {
				int subjectID = Integer.parseInt(enterValue("Enter SubjectID: "));
				int hours = Integer.parseInt(enterValue("Enter required hours: "));
				int experience = Integer.parseInt(enterValue("Teacher's Experience: "));
				controller.addNewRequirement(subjectID, hours, experience);
				break;
			}
			case 2: {
				System.out.println("View list of all requirement");
//				controller.  => getAll method also should be implemented in the Controller class
				break;
			}
			case 3: {
				System.out.println("View list of all teachers");
//				controller we don't have method to get list of all teachers existed in our database;
				break;
			}
			case 4: {
				System.out.println("For adding new teacher please specify teacher details: ");

				String name = enterValue("Teacher's name: ");
				int subjectID = Integer.parseInt(enterValue("Teacher's subject ID: "));
				int experience = Integer.parseInt(enterValue("Teacher's Experience: "));
				controller.addNewTeacher(name, subjectID, experience);
				break;
			}
			case 5: {
				System.out.println("List of matched teachers");
				String subjectID = enterValue("Enter SubjectID: ");
				List<Teacher> listOfMatchedTeachers = controller.matchTeacherWithRequirement(subjectID);
				int order = 1;
				for (Teacher teacher : listOfMatchedTeachers) {
					System.out.println(order++ + ". " + teacher.getName() + ". taught subject id is "
							+ teacher.getSubjectId() + " and has " + teacher.getExperience() + " years experience");
				}

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + operation);
			}

		} else if (role.equals("administrator")) {
			System.out.println(menuListForAdministrator());
		}

	}

	private static String menuListForDirector() {
		return ("Choose operation you want to execute: " + "\n1. Add requirement" + "\n2. View list of all requirement"
				+ "\n3. View list of all teachers" + "\n4. Add new teacher" + "\n5. List of macthed teachers"
				+ "\n4. Add new teacher");
	}

	private static String menuListForAdministrator() {
		return ("Choose operation you want to execute: " + "\n1. View list of all requirement"
				+ "\n2. View list of all teachers" + "\n3. Add new teacher" + "\n4. List of macthed teachers"
				+ "\n5. Add new teacher" + "\n6. Booking training");
	}

	private static String enterValue(String message) {// method for the Scanner to get value from user
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		sc = new Scanner(System.in);
		return sc.nextLine();// value that is entered from terminal by user
	}
}
