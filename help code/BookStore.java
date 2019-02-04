import java.util.Scanner;

/**
 * @author Michal Aibin
 */
public class BookStore {

	public static void main(String[] args) {
		// Variables
		int books; // Number of books purchased
		int points; // Points awarded

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Get the number of books purchased this month.
		System.out.print("How many books have you purchased this month? ");
		books = keyboard.nextInt();

		// Determine the number of points to award.
		switch (books) {
		case 0:
			points = 0;
			break;
		case 1:
			points = 1;
			break;
		case 2:
			points = 3;
			break;
		case 3:
			points = 5;
			break;
		default:
			points = books * 5;
			break;
		}

		// Display the points earned.
		System.out.println("You've earned " + points + " points.");
		keyboard.close();
	}

}
