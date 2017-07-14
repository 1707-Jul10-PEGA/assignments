package q20;
import java.io.*;
import java.util.*;

public class Read_info {
	
	
	public static void main(String[] args) throws IOException{
		//System.out.println(new File(".").getAbsoluteFile());
		
		String[] line;
		File my_File  = new File("src//q20//Data.txt");
		Scanner file_Reader = new Scanner(my_File);
		
		
			
		while(file_Reader.hasNextLine()){
			line = file_Reader.nextLine().split(":");
			
			print_info(line);
			
			
		}
		
		
		file_Reader.close();
		
	}
	
	
	
	private static void print_info(String[] line){
		System.out.println("Name: " + line[0] + 
							"\nAge: " + line[1] +
							"\nState: " + line[2] + "\n");
		
		
	}

}
