package q14;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SwitchExample {

	private static final DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	public static void main(String[] args) {

		System.out.println("Please Choose an Option.");
		System.out.println("1 = Find the square root of a number");
		System.out.println("2 = Display todays date.");
		System.out.println("3 = Split:\n\t'I am learning Core Java'\n\tand store it in sting array.");
		System.out.print("\nOption: ");
		Scanner n = new Scanner(System.in);
		int choice = n.nextInt();
		
		switch (choice) {
		
		case 1: Scanner p = new Scanner(System.in);
				System.out.print("Enter an Integer: ");
				int choice2 = p.nextInt();
				System.out.println(Math.sqrt(choice2));
				break;
		case 2: LocalDate localDate = LocalDate.now();
				System.out.print("Today's Date: ");
				System.out.println(DateTimeFormatter.ofPattern( "MM/dd/yyyy").format(localDate));
				break;
		case 3: System.out.println("Very well.");
				String sentence = "I am learning Core Java!";
				String[] splitSentence = sentence.split(" ");
				for(String split : splitSentence) {
					System.out.println(split + " ");
					}
				break;
		}
	}

}