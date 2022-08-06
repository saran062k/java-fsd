package iostreams;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Filedisplay {

	public void display() throws IOException {
		String path="D:\\virtualkey\\";
		System.out.println("displaying file");
		File f=new File(path);
		//display operation
		File filenames[]=f.listFiles();
		for(File ff:filenames) {
			System.out.println(ff.getName());
			
		}
		}

}

