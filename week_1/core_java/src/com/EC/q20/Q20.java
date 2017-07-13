package com.EC.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q20 {

	public static void main(String[] args) {

		List<Person> listOfPpl = new ArrayList<Person>();
		try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
			for (String line; (line = br.readLine()) != null;) {
				Person p = new Person();
				String[] strArr = line.split(":");
				p.setFirstName(strArr[0]);
				p.setLastName(strArr[1]);
				p.setAge(Integer.parseInt(strArr[2]));
				p.setState(strArr[3]);
				listOfPpl.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Person p : listOfPpl){
			System.out.println(p.toString()+"\n");
		}

	}
}
