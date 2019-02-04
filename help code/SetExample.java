import java.util.HashSet;
import java.util.Set;

/**
 * Simple Hash Set implementation example
 * 
 * @author Michal Aibin
 */
public class SetExample {

	public static void main(String args[]) {

		Set<String> names = new HashSet<>();

		/* This is how elements should be added to the hash set */
		names.add("Harry");
		names.add("Steve");
		names.add("Chris");

		/* Displaying elements of the hash set */
		System.out.println("Starting array list has following elements: "
				+ names);

		/* Try to add duplicate element */
		names.add("Harry");

		System.out.println("Current array list is: " + names);

		/* Remove an element from the hash set */
		names.remove("Harry");

		System.out.println("Current array list is: " + names);

		for (String name : names) {
			System.out.println("Current name in array list is: " + name);
		}

		System.out.println("Final size of the hash set is " + names.size());
		
	}

}
