package iostreams;

import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class FileEx {

	public static void main(String[] args)throws IOException  {
		Fileadd a=new Fileadd();
		Filedelete d=new Filedelete();
		Filedisplay ds=new Filedisplay();
		Filesearch s=new Filesearch();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome");
		do
		{
			System.out.println("enter your choice 1.retrivefile 2.operation 3.close");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				ds.display();
			    break;
			 case 2:
				 int temp=1;
				do {
					System.out.println("enter the operation to perform 1.addfile 2.deletefile 3.search 4.return to main content");
					int option=sc.nextInt();
					switch(option) {
					case 1: 
						a.add();
						break;
					case 2:
						d.delete();
						break;
					case 3:
						s.search();
						break;
					case 4:
						temp=0;
						break;
					default:
						System.out.println("invalid");
						break;
					}
		            }while(temp==1);
				break;
			  
			case 3:
				System.out.println("closing the application");
				System.exit(0);
				break;
			default:
				System.out.println("invalid choice");
				break;	
			}
			
		}while(true);
		
		

	}

}

