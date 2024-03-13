package Application.Views;
import Application.Controllers.Controller;


public class DirectorMenu implements Menu{

//	//	To implement operation based on director selection	
	public void showMenuList(Controller controller) {

		System.out.println(menuListForDirector());
		int operation = Integer.parseInt(InputUtil.enterValue("Choose operation by selecting appropriate value: "));
		switch (operation) {
		case 0: {
			ViewRequestsOperations.MainMenu();
			break;
		}
		case 1: {
			ViewRequestsOperations.requestAddRequirement(controller);
			break;
		}
		case 2: {
			System.out.println("View list of all requirement");
//			controller.  => getAll method also should be implemented in the Controller class
			//method to display teaching requiremenrts
			controller.displayTeachingRequirements();
			
			break;
		}
		case 3: {
			System.out.println("View list of all teachers");
//			controller we don't have method to get list of all teachers existed in our database;
			//method to display teachers
			controller.displayTeachers();
			break;
		}
		case 4: {
			ViewRequestsOperations.requestAddTeacher(controller);
			break;
		}
		case 5: {
			ViewRequestsOperations.requestGetListOfMachedTeachers(controller);
			break;
		}

		case 6: {
			ViewRequestsOperations.closeApp();
			break;
		}
		default: {
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}

		}
	}
	// List of menu elements for director
	private String menuListForDirector() {
		return ("You are in the Director panel: " + "\n0 Go to Main menu" + "\n1. Add requirement"
				+ "\n2. View list of all requirement" + "\n3. View list of all teachers" + "\n4. Add new teacher"
				+ "\n5. List of macthed teachers" + "\n6. Close the app");
	}
}
