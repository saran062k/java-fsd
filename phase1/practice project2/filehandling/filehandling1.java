package filehandling;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class filehandling1 {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\data.txt");
		if(file.createNewFile()) {
			System.out.println(file.exists());
		}
		
		FileWriter fw = new FileWriter(file);
		fw.write("Hello Everyone \nHow are you");
		fw.flush();
		System.out.println("Reading content in the file");
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			String content = reader.nextLine();
			System.out.println(content);
		}
		System.out.println("File reading is over");
		reader.close();
		System.out.println("\n\nAppending...");
		FileWriter fw1 = new FileWriter(file, true);
		fw1.write("\nWelcome to java");
		fw1.flush();
		System.out.println("new text is appended into the file");

	}
}
