package serialization;

import java.io.Serializable;
import java.util.Scanner;

import Week1.Person;


public class Launcher implements Serializable {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// create person class 
		Person p = new Person();
		System.out.print("Please enter your first name: ");
		p.setFirstName(scan.nextLine());
		System.out.print("Please enter your last name: ");
		p.setLastName(scan.nextLine());
		
		System.out.println("your person object: " + p);

		scan.close();
		
		
		
		
		
		if(scan.hasNextInt()) {
		String input = scan.nextLine();
		Integer.get
		System.out.println(input);
	}
	}
	
			

}
