package Application.Views;

import Application.Controllers.Controller;


//Entry view to application ; loops through options menu until the user sends close command
public class Terminal {
	public static void main(String[] args) {

		ViewRequestsOperations applicationView = new ViewRequestsOperations(new Controller());

		while (applicationView.isOpen()) {
			mainMenu(applicationView);
		}
	}

//Displays the appropriate options menu depending on the user-role
//If there were more roles it could use a seperate factory class instead to instantiate the correct menu object
	private static void mainMenu(ViewRequestsOperations view) {
		String role = InputUtil.enterValue("What is your role: ").toLowerCase();
		Menu roleMenu = null;
		
		if (role.equals("director")) {
			roleMenu = new DirectorMenu(view);
		} 
		else if (role.equals("administrator") || role.equals("admin")) {
			roleMenu = new AdministratorMenu(view);
		}

		if (roleMenu != null) {
			roleMenu.showMenuList();
		}
		else{
			System.out.println("Unrecognsied role");
		}
	}
















	

}