import java.util.Scanner;

/**
 * @author Michal Aibin
 */
public class BodyMassIndex {
	public static void main(String[] args) {
		// Variables
		double weight; // The user's weight
		double height; // The user's height
		double bmi; // The user's BMI

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Tell the user what the program will do.
		System.out.println("This program will calculate your body mass index, or BMI.");

		// Get the user's weight.
		System.out.print("Enter your weight, in pounds: ");
		weight = keyboard.nextDouble();

		// Get the user's height.
		System.out.print("Enter your height, in inches: ");
		height = keyboard.nextDouble();

		// Calculate the user's body mass index.
		bmi = weight * 703 / (height * height);

		// Display the user's BMI.
		System.out.println("Your body mass index (BMI) is " + bmi);

		// Determine whether the user is underweight,
		// overweight, or has optimal weight.
		if (bmi < 18.5)
			System.out.println("You are underweight.");
		else if (bmi > 25)
			System.out.println("You are overweight.");
		else
			System.out.println("Your weight is optimal.");

		keyboard.close();
	}
}
