import java.util.Scanner;

/**
 * @author Michal Aibin
 */
public class RestaurantBill {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Constants
		final double TAX_RATE = 0.0675; // Tax rate
		final double TIP_PERCENT = 0.15; // Tip percentage

		// Variables
		double mealCharge; // To hold the meal charge
		double tax; // To hold the amount of tax
		double tip; // To hold the tip amount
		double total; // To hold the total charge

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Get the charge for the meal.
		System.out.print("Enter the charge for the meal: ");
		mealCharge = keyboard.nextDouble();

		// Calculate the tax.
		tax = mealCharge * TAX_RATE;

		// Calculate the tip.
		tip = mealCharge * TIP_PERCENT;

		// Calculate the total.
		total = mealCharge + tax + tip;

		// Display the results.
		System.out.println("Meal Charge: $" + mealCharge);
		System.out.println("Tax:         $" + tax);
		System.out.println("Tip:         $" + tip);
		System.out.println("Total:       $" + total);
		
		keyboard.close();
	}

}
