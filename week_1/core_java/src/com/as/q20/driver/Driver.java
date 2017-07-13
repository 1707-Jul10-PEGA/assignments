package com.as.q20.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.as.q20.person.Person;

public class Driver {
	public static void main(String[] args) {
		String filename = "Data.txt";
		ArrayList<Person> personList = new ArrayList<Person>();	
		
		try {
			FileInputStream in = new FileInputStream(filename);
			Scanner s = new Scanner(in);
						
			while (s.hasNext()) {
				Person p = new Person();
				
				String str = s.nextLine();
				String[] strArr = str.split(":");
				if (strArr.length == 4) {
					p.setFirstName(strArr[0]);
					p.setLastName(strArr[1]);
					p.setAge(strArr[2]);
					p.setState(strArr[3]);
				}
				
				//add the person to the list
				personList.add(p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(personList.get(0));
	}
}
