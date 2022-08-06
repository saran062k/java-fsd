package iostreams;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Filedelete {

	public void delete() throws IOException {
		String path="D:\\virtualkey\\";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the filename to be deleted");
		String filename=sc.next();
		String finalpath=path+filename;
		File f=new File(finalpath);
		f.delete();
		System.out.println("file deleted");

	}

}
