package Application.Views;

import java.util.Scanner;

public class InputUtil {

	public static String enterValue(String message) {// method for the Scanner to get value from user

		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		sc = new Scanner(System.in);
		
		return sc.nextLine();// value that is entered from terminal by user
	}
}
