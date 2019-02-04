import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Michal Aibin
 */
public class InputOutput {

	public static void main(String[] args) {
		String fileStr = "names.txt"; 	//file
		Path path = Paths.get(fileStr); //to create a path to file
		int lineCount = 0;  			// To count lines
		Charset charset = Charset.forName("UTF-8");
		String inLine; 					//currentLine
		try (BufferedReader in = Files.newBufferedReader(path, charset)) {
			while ((inLine = in.readLine()) != null) {
				System.out.println(inLine);
				lineCount++;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Number of lines in the file equals: " + lineCount);
	}
}
