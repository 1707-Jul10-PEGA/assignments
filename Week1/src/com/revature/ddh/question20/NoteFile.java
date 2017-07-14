package com.revature.ddh.question20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class NoteFile {

	public static void main(String[] args) throws FileNotFoundException {

			int count = 0;
			Scanner scan = new Scanner(new File ("/Users/Atlas/Desktop/workspace-sts-3.9.0.RELEASE/Week1/src/com/revature/ddh/question20/Data.txt"));
			scan.useDelimiter(":|\\n");
			while (scan.hasNext()) {
				//count ++;
				/*if (count >= 4 ) {
				System.out.println();
					//count = 0;
				}*/
				//System.out.println("Name: ");
				System.out.print("Name: " + scan.next() + " "+ scan.next() + "\n" + "Age: " + scan.next() + "\n"+ "State: " +  scan.next() + "\n"+ "\n");
				
			}
			scan.close();
		
			}

	



}
