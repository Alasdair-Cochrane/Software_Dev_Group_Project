package Application.Views;

import java.util.List;

import Application.Controllers.Controller;
import Application.Models.*;

public class DirectorMenu extends Menu{
	static DirectorMenu instanceDirectorMenu;
	
	public DirectorMenu(ViewRequestsOperations view){
		super(view);
	}
	

//	//	To implement operation based on director selection	
	public void showMenuList() {

		System.out.println(menuListForDirector());
		int operation = Integer.parseInt(InputUtil.enterValue("Choose operation by selecting appropriate value: "));
		switch (operation) {
		case 0: {
			return;
		}
		case 1: {
			view.requestAddRequirement();
			break;
		}
		case 2: {
			System.out.println("View list of all requirement");
//			controller.  => getAll method also should be implemented in the Controller class
			//method to display teaching requiremenrts
			view.displayTeachingRequirements();
			
			break;
		}
		case 3: {
			System.out.println("View list of all teachers");
//			controller we don't have method to get list of all teachers existed in our database;
			//method to display teachers
			view.displayTeachers();
			break;
		}
		case 4: {
			view.requestAddTeacher();
			break;
		}
		case 5: {
			view.requestGetListOfMatchedTeachers();
			break;
		}

		case 6: {
			view.closeApp();
			break;
		}
		default: {
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}

		}
	}

//	Middle layer method for view function to call the "menuList" method to make selection for operation

	// List of menu elements for director
	private static String menuListForDirector() {
		return ("You are in the Director panel: " + "\n0 Go to Main menu" + "\n1. Add requirement"
				+ "\n2. View list of all requirement" + "\n3. View list of all teachers" + "\n4. Add new teacher"
				+ "\n5. List of matched teachers" + "\n6. Close the app");
	}







}
