import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


/**
 * 
 */

/**
 * @author Brandon Frison 300243731
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numOfCars; //sets number of cars and parking spots in the simulation between 1 and 10
		numOfCars = randInt(1,10);
		int carSize;
		int duration;
		int spotSize;
		double total = 0;
		double price = 0; //default at 5 per hour
		
		Car currentcar = new Car(); //creates car object
		ParkingSpot parkingspots = new ParkingSpot(); //creates parking spot object
		PoliceOfficer tickets = new PoliceOfficer();
		//sends a police officer to check for violations
		
		for(int i = 0; i < numOfCars; i++){
			
			//all randInts generate new every loop to simulate a new car in a new parking spot with a new duration.
			
			tickets.setTimeTicket(0); //resets there to be no ticket for the next car
			
			carSize = randInt(1,2); //1 = small, 2 = large
			currentcar.setCarSize(carSize);
			duration = randInt(1,30); // if duration is greater than 20 then give a ticket
			currentcar.setDuration(duration);
			
			
			spotSize = randInt(1,3); //1 = small, 2 = medium, 3 = large
			parkingspots.setSizeSpaces(spotSize);
			
			
			//Price changes depending on duration of stay and checks for need for ticket
			if(currentcar.getDuration() < 10){
				price = 5.75;
			}else if(currentcar.getDuration() < 20){
				price = 10.25;
			}else{
				price = 15.50;
				tickets.setTimeTicket(1); //sets the ticket to 1 meaning that they got a ticket for exceeding duration
			}
			parkingspots.setPrice(price * carSize + (2*spotSize)); //price doubles if the car is a large car and the spot size changes it
			
			String fileStr = "carnumber"+(i+1)+"report.txt";
			Path path = Paths.get(fileStr);
			Charset charset = Charset.forName("UTF-8");
			try (BufferedWriter out = Files.newBufferedWriter(path, charset)) {
				out.write("For car number "+ (i+1));
				out.newLine();
				out.write("the price per hour of this parking spot is " + parkingspots.getPrice() + " per hour");
				out.newLine();
				out.write("the car size was of class: " + currentcar.getCarSize()+ "   (1 = small, 2 = large)");
				out.newLine();
				out.write("the parking spot size was: " + parkingspots.getSizeSpaces() + "   (1=small,2=medium,3=large)");
				out.newLine();
				out.write("the duration of the stay was " + currentcar.getDuration() + " minutes");
				
				total = currentcar.getDuration() * parkingspots.getPrice(); 
				total = total/60;
				total = (double)Math.round(total * 100d) / 100d; //rounds to two decimal places
				if(tickets.getTimeTicket() == 1){
					total += 85;
					out.newLine();
					out.write("A ticket of $85 was given to this car for exceeding the parking duration of 20 minutes");
					}
				
				out.newLine();
				out.write("total price for this car was $" + total);
				out.newLine();
				out.newLine();
				out.close();
			} catch (IOException ex) {}
			
			
			
			
		}
		System.out.println("File has been successfully created in default directory for java project");
	}
	
	public static int randInt(int min, int max) {
		//creates a random number between two specified values including them
	    Random randy = new Random();
	    int rNumber = randy.nextInt((max - min) + 1) + min;
	    return rNumber;
	}
}
