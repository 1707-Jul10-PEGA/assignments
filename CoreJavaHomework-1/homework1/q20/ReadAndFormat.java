package q20;

import java.io.*;

public class ReadAndFormat {

	public static void main(String[] args) {
		
		try {
			File file = new File("Data.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String inputLine;
			while((inputLine = br.readLine()) != null) {
				
				organizeLine(inputLine);
			}
		
			fr.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void organizeLine(String sb) {

		String firstName = "";
		String lastName = "";
		String age = "";
		String state = "";
		
		String[] xx = sb.split(":");
		firstName = xx[0];
		lastName = xx[1];
		age = xx[2];
		state = xx[3];
		
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Age: " + age);
		System.out.println("State: " + state + "\n");
		

		
	}
	

}
