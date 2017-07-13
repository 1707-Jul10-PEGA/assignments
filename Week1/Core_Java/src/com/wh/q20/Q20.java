package com.wh.q20;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q20 {
	public static void main(String[] args) {
		String[] data;
		try(Scanner scan = new Scanner(new FileReader("Data.txt"))){
			while(scan.hasNextLine()){
				data = scan.nextLine().split(":");
				System.out.println("Name: " + data[0] + " " + data[1]);
				System.out.println("Age: " + data[2] + " years");
				System.out.println("State: " + data[3] + " State");
				System.out.println();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
