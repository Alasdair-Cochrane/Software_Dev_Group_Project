package Application.Views;

import Application.Controllers.Controller;

public class Terminal {
	public static void main(String[] args) {

		ViewRequestsOperations applicationView = new ViewRequestsOperations(new Controller());
		while (applicationView.isOpen()) {
			mainMenu(applicationView);
		}
	}

	protected static void mainMenu(ViewRequestsOperations view) {
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
