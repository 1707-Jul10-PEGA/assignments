//Carson Stephens
//07-11-2017

package com.cts.q20;

import java.io.*;
import java.util.*;

//Class to hold relevant data
class Person
{
	public String fname;
	public String lname;
	public int age;
	public String state;
	
	//Constructor
	public Person(String fname, String lname, int age, String state)
	{
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.state = state;
	}
}

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q20");
		
		//ArrayList of people
		ArrayList<Person> people = new ArrayList<Person>();
		
		//Name of the file to open
		String filename = "Data.txt";
		
		//Reference file one line at a time
		String line = "";
		
		try
		{
			//Read text file
			FileReader fr = new FileReader(filename);
			
			//Wrap FileReader in BufferedReader
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null)
			{
				String[] data = line.split(":");
				if (data.length >= 4)
				{
					String fname = data[0];
					String lname = data[1];
					int age = Integer.parseInt(data[2]);
					String state = data[3];
					people.add(new Person(fname, lname, age, state));
				}
			}
			
			br.close();
		}
		
		//Make sure that the file could be found
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file");
			return;
		}
		
		//Make sure that the file could be read
		catch(IOException e)
		{
			System.out.println("Error reading file");
			return;
		}
		
		for (Person p : people)
		{
			System.out.println("Name: " + p.fname + " " + p.lname);
			System.out.println("Age: " + p.age + " years");
			System.out.println("State: " + p.state + " State\n");
		}
	}
}
