package Application.Views;

public class Terminal {
	public static void main(String[] args) {
//		boolean isActive = true;
		while (ViewRequestsOperations.isClosed()) {
			ViewRequestsOperations.MainMenu();
		}

	}

}
