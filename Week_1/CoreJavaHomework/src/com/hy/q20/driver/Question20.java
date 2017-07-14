package com.hy.q20.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question20 {
	private void displayFile(String filename){
		try {
			Scanner sc = new Scanner(new FileReader(filename));
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				String[] str = line.split(":");
				System.out.println("Name: " + str[0] + " " + str[1]);
				System.out.println("Age: " + str[2] + " years");
				System.out.println("State: " + str[3] + " State");
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Question20().displayFile("Data.txt");
	}
}
