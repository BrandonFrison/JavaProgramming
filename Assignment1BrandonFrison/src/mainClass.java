import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Brandon Frison SID = 300243731
 * level 3 attempt
 *
 */
public class mainClass {

	/**
	 * @param args
	 */
	static HashMap<Integer,Integer> userMap = new HashMap<>(); //creating of database/map to store users	
	public static void main(String[] args) {
		//variables below here
		int books; // number of books purchased
		int clientID; // id of each client
		int menuID = 0; // menu option
		Scanner keyboardInput = new Scanner(System.in); //scanner
					
		//default message for menu
		printMenuMethod();
		menuID = keyboardInput.nextInt();
					
		while (menuID >= 0 && menuID <= 4)
		{
						
			switch (menuID)
			{
			case 0:
				keyboardInput.close();
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter the client ID number who's points you want to check here:");
				clientID = keyboardInput.nextInt();
				printPointMethod(clientID);
				break;
			case 2:
				printDocumentMethod();
				break;
			case 3:
				System.out.println("Enter the new client ID number here:");
				clientID = keyboardInput.nextInt();
				createNewUserMethod(clientID);
				break;
			case 4:
				System.out.println("Enter the client ID number here:");
				clientID = keyboardInput.nextInt();
				System.out.println("Enter the number of books purchased here:");
				books = keyboardInput.nextInt();
				calculatePointsMethod(clientID, books);
				break;
			default:
				printMenuMethod();
				menuID = keyboardInput.nextInt(); 
				// if a non case number is inputed then restart at menu
				break;
				
			}
			printMenuMethod();
			menuID = keyboardInput.nextInt(); //reprints menu after action is completed.
		}
				
		keyboardInput.close();
	}
	
	public static void printPointMethod(int cid){
		Integer points = userMap.get(cid); // points awarded for book purchases
		System.out.println("The current points of user " + cid + " is " + points);
		}
	
	public static void printMenuMethod(){
		System.out.println("\nEnter a menu number to continue of either: \n0 (to exit the program) \n1 (to print a clients points value)\n2 (to generate a file with all clients information)\n3 (to add a new user to the book store)\n4 (to add books being purchased by a user)\n");
	}
	
	public static void createNewUserMethod(int cid2){
		Integer oldPoints = userMap.get(cid2);
		if(oldPoints == null){
			userMap.put(cid2, 0); //0 will be the points value as it starts with 0
		}else{
			userMap.put(cid2, oldPoints); //if the user is already there it will not reset the points to 0
		}
		
		
		for (Integer i : userMap.keySet()){ //iterates through keys and check if the client id already exists
		if(i == cid2){
			System.out.println("Client ID already exists");
			break;
			}
		else{
			System.out.println("User has been created successfully");
			break;
			}
		}
	}
	
	public static void printDocumentMethod(){

		String fileStr = "bookstoreUserPoints.txt";
		Path path = Paths.get(fileStr);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter out = Files.newBufferedWriter(path, charset)) {
		 //text to write here
			Iterator<Entry<Integer, Integer>> it = userMap.entrySet().iterator(); //iterates through the hashmap with both key and value stored
			List<Integer> sortingList = new ArrayList<Integer>(); //list to use to sort the points
			while (it.hasNext()) {
		       Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>)it.next(); //goes through each value pair in the map
		       
		       
		       sortingList.add(pair.getValue()); // adds the points value to the list
		       Collections.sort(sortingList); //sorts the list
		       Collections.reverse(sortingList); //puts the sort in descending order
		       
		       out.write("user ID " + pair + " points, "); //actually prints to the file
		       it.remove(); //useful for avoiding an exception error
		    }
			String test = "";
			for (Integer b : sortingList)
			{
			    test += b + " --> ";
			}
			out.newLine();
			out.write("sorted point order below look above for corresponding User ID");
			out.newLine();
		    out.write(test);	   //prints sorted points to the document
		    		    
		 System.out.println("File has been successfully created in default directory for java project");
		} catch (IOException ex) {}
	    
	}
	
	public static void calculatePointsMethod(int cid3, int num){
		int points;
		Integer totalPoints;
		// to find the number of points to award the user.
				switch (num) {
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
					points = num * 5;
					break;
				}
				Integer OldPoints = userMap.get(cid3);
				if(OldPoints != null){
					totalPoints = points + OldPoints; //adds new points to the old points amount
				}
				else
				{
					totalPoints = points; //adds only new points
				}
				userMap.put(cid3, totalPoints);		//adds the new total points to that user		
				System.out.println(points + " Points successfully added to user " + cid3);
		}

}
