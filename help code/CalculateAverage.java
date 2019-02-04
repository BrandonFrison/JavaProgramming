import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Michal Aibin
 */
public class CalculateAverage {

	public static void main(String[] args) {
		String fileStr = "numbers.txt"; // file
		Path path = Paths.get(fileStr); // to create a path to file
		int sumOfNumbers = 0, count = 0; // To count lines
		Charset charset = Charset.forName("UTF-8");
		String inLine; // currentLine
		try (BufferedReader in = Files.newBufferedReader(path, charset)) {
			while ((inLine = in.readLine()) != null) {
				sumOfNumbers += Integer.parseInt(inLine);
				count++;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Average: " + calculateAverage(sumOfNumbers, count));
	}

	/**
	 * @param sumOfNumbers
	 * @return
	 */
	private static Integer calculateAverage(int sumOfNumbers, int count) {
		return sumOfNumbers/count;
	}

}
