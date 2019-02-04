import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Michal Aibin
 */

public class PrimeNumberList {

	public static void main(String[] args) throws IOException {

		String fileStr = "average.txt"; // file
		Path path = Paths.get(fileStr); // to create a path to file
		Charset charset = Charset.forName("UTF-8");

		try (BufferedWriter out = Files.newBufferedWriter(path, charset)) {
			// Write the prime number list.
			for (int i = 1; i <= 100; i++) {
				if (isPrime(i)){
					System.out.println("Is prime: " + i);
					out.write("Is prime: " + i);
					out.newLine();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * The isPrime method determines whether a number is prime.
	 * 
	 * @param num
	 *            The number to check.
	 * @return true if the number is prime, false otherwise.
	 */
	public static boolean isPrime(int num) {
		boolean divisorFound = false;
		int div = 2;

		while (div < num && !divisorFound) {
			if ((num % div) == 0)
				divisorFound = true;
			div++;
		}
		return !divisorFound;
	}
}