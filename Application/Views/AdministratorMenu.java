package Application.Views;
public class AdministratorMenu implements Menu{

	private ViewRequestsOperations view;

	public AdministratorMenu(ViewRequestsOperations view)
	{
		this.view = view;
	}

//	To implement operation based on administrator selection
	public void showMenuList() {
		System.out.println(menuListForAdministrator());
		int operation = Integer.parseInt(InputUtil.enterValue("Choose operation by selecting appropriate value: "));

		switch (operation) {
		case 0: {
			return;
			
		}
		//methods gives an error when it tries to display the database -Nduka
		case 1: {
			System.out.println("View list of all requirement");
//			controller.  => getAll method also should be implemented in the Controller class
			view.displayTeachingRequirements();
			break;
		}
		case 2: {
			System.out.println("View list of all teachers");
			view.displayTeachers();
			break;
		}
		
		//This method gives an error when it tries to add a teacher to the database -Nduka
		case 3: {
			view.requestAddTeacher();
			break;
		}
		case 4: {
			view.requestGetListOfMachedTeachers();
			break;
		}
		case 5: {
			System.out.println("Booking training");
//		;
			
			view.BookTraining();
			break;
		}
		case 6: {
			view.closeApp();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}
	}

	// List of menu elements
	private String menuListForAdministrator() {
		return ("You are in the Administrator panel: " + "\n0. Go to Main menu" + "\n1. View list of all requirement"
				+ "\n2. View list of all teachers" + "\n3. Add new teacher" + "\n4. List of macthed teachers"
				+ "\n5.Booking training" + "\n6. Close the app");
	}


}
