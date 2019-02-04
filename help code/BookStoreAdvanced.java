import java.util.Scanner;

/**
 * @author Michal Aibin Provide implementation of following: 1. Number of books
 *         allowed to buy at once is no more 5. If user wants to buy more, print
 *         a message, that this is not possible. If action is successful,
 *         subtract shopped books from company storage 2. Add 3 points per each
 *         book to the company records array. Index of array is equal to a client
 *         id. We have 3 clients with an id between 0-2. If client is not found,
 *         print a message and subtract number of books from the storage. 3.
 *         After simulation, print all the clients with their points value,
 *         using for loop.
 */
public class BookStoreAdvanced {

	private static int numberOfBooksInStore = 25;
	private static int[] companyRecords = new int[3]; // Clients data

	public static void main(String[] args) {
		// Variables
		int books; // Number of books purchased
		int clientID; // Client ID
		int points = 0; // Points awarded

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		do {
			// Get the number of books purchased this month.
			System.out.print("Which client ID do you use? ");
			clientID = keyboard.nextInt();
			System.out.print("How many books have you purchased this week? ");
			books = keyboard.nextInt();

			// Determine the number of points to award.
			switch (clientID) {
			case 0:
				companyRecords[0] += points;
				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}

			System.out
					.println("You've earned " + points + " points this time.");

		} while (numberOfBooksInStore >= 0);

		System.out.println("We sold all books in this week!");

		keyboard.close();
	}

}
