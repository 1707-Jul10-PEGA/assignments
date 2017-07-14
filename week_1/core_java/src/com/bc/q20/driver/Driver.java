package com.bc.q20.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FileWriter f = null;
		try {
			f = new FileWriter("Data.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			f.write("Mickey:Mouse:36:Arizona\n");
			f.write("Hulk:Hogan:50:Virginia\n");
			f.write("Roger:Rabbit:22:California\n");
			f.write("Wonder:Woman:18:Mountana\n");
			f.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner scan = null;
		try {
			scan = new Scanner(new File("Data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// scan each line of the textfile into ArrayList<String>
		ArrayList<String> lines = new ArrayList<String>();
		while(scan.hasNextLine()){
			lines.add(scan.nextLine());
		}
		
		//Each element in ArrayList<String> is split for sysout
		String[] strArr;
		for(String s : lines){
			strArr = s.split(":");
			System.out.println("Name: " + strArr[0] + " " + strArr[1]);
			System.out.println("Age: " + strArr[2] + " years");
			System.out.println("State: " + strArr[3] + " State\n");
		}
		
	}

}
