package Application.Views;

import Application.Controllers.Controller;

public class AdministratorMenu {

	static AdministratorMenu instanceAdministratorMenu;;

//	To implement operation based on administrator selection
	private void menuList(Controller controller) {
		System.out.println(menuListForAdministrator());
		int operation = Integer.parseInt(InputUtil.enterValue("Choose operation by selecting appropriate value: "));

		switch (operation) {
		case 0: {
			ViewRequestsOperations.MainMenu();
			break;
		}
		//methods gives an error when it tries to display the database -Nduka
		case 1: {
			System.out.println("View list of all requirement");
//			controller.  => getAll method also should be implemented in the Controller class
			controller.displayTeachingRequirements();
			break;
		}
		case 2: {
			System.out.println("View list of all teachers");
			controller.displayTeachers();
			break;
		}
		
		//This method gives an error when it tries to add a teacher to the database -Nduka
		case 3: {
			ViewRequestsOperations.requestAddTeacher(controller);
			break;
		}
		case 4: {
			ViewRequestsOperations.requestGetListOfMachedTeachers(controller);
			break;
		}
		case 5: {
			System.out.println("Booking training");
//		;
			
			ViewRequestsOperations.BookTraining(controller);
			break;
		}
		case 6: {
			ViewRequestsOperations.closeApp();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}
	}

//	Middle layer method for view function to call the "menuList" method to make selection for operation
	public static void showAdministratorMenuList(Controller controller) {
		if (instanceAdministratorMenu == null) {
			instanceAdministratorMenu = new AdministratorMenu();
			instanceAdministratorMenu.menuList(controller);
		} else {
			instanceAdministratorMenu.menuList(controller);

		}
	}

	// List of menu elements
	private static String menuListForAdministrator() {
		return ("You are in the Administrator panel: " + "\n0. Go to Main menu" + "\n1. View list of all requirement"
				+ "\n2. View list of all teachers" + "\n3. Add new teacher" + "\n4. List of macthed teachers"
				+ "\n5.Booking training" + "\n6. Close the app");
	}
}
