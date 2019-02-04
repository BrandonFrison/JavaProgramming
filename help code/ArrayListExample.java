import java.util.ArrayList;

/**
 * Simple Array List operations example
 * 
 * @author Michal Aibin
 */
public class ArrayListExample {

	public static void main(String args[]) {

		ArrayList<String> names = new ArrayList<>();

		/* This is how elements should be added to the array list */
		names.add("Harry");
		names.add("Steve");
		names.add("Chris");

		/* Displaying elements of the array list */
		System.out.println("Starting array list has following elements: "
				+ names);

		/* Add element at the given index */
		names.add(names.size(), "Justin");
		names.add(1, "Tim");

		System.out.println("Current array list is: " + names);
		
		/* Remove elements from the array list */
		names.remove("Harry");
		
		System.out.println("Current array list is: " + names);
		
		for (String name: names){
			System.out.println("Current name in array list is: " + name);
		}
		
		System.out.println("Final size of the array list is " + names.size());

	}
}