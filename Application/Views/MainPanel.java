package Application.Views;

import java.util.Scanner;

public class MainPanel {

	public static void main(String[] args) {
		String role;
		System.out.println(" What is your role: ");
		Scanner sc = new Scanner(System.in);
		role = sc.nextLine().toLowerCase();
		if (role.equals("director")) {
			menuListForDirector();
		} else if (role.equals("administrator")) {
			menuListForAdministrator();
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

}
