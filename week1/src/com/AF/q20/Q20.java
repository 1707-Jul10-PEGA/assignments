package com.AF.q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


class Character{
	
	String name;
	int age;
	String location;
	
	Character(String name, int age, String place) {
		this.name = name;
		this.age = age;
		this.location = place;
	}
	
	public String getName() { return this.name; }
	public int getAge() { return this.age; }
	public String getLocation() { return this.location; }
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: ");
		sb.append(this.getName() + "\n");
		
		sb.append("Age: ");
		sb.append(this.getAge() + "\n");
		
		sb.append("State: ");
		sb.append(this.getLocation() + "\n");
		
		System.out.println(sb);
	}
}

public class Q20 {
	
	public static Character readFileLine(String fileName) {
		String[] data = fileName.split(":");
		
		return new Character(data[0] + " " + data[1], Integer.parseInt(data[2]), data[3]);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner s = new Scanner(new File("Data.txt"));
		ArrayList<Character>characters = new ArrayList<Character>();
		
		while(s.hasNext()) {
			characters.add(readFileLine(s.next()));
		}
		s.close();
		
		for(Character c : characters) {
			c.print();
		}	
	}
}
