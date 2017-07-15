package com.aw.q7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployees {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Cyril", "Accounting", 48),
                new Person("Pam", "Human Resources", 38)
        );
        Collections.sort(people, new firstNameComparator());
        System.out.println(Arrays.toString(people.toArray())); 
        Collections.sort(people, new departmentComparator());
        System.out.println(Arrays.toString(people.toArray()));
        Collections.sort(people, new AgeComparator());
        System.out.println(Arrays.toString(people.toArray()));
    }
}

//compareToIgnoreCase compares string and gives back -1, 0 , 1

class firstNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.name.compareToIgnoreCase(b.name);
    }
}

class departmentComparator implements Comparator<Person>{
	@Override
	public int compare (Person a, Person b){
		return a.department.compareToIgnoreCase(b.department);
	}
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
    }
}

class Person {

    String name;
    String department;
    int age;

    Person(String n, String d, int a) {
        name = n;
        department = d;
        age = a;
    }

	@Override
	public String toString() {
		return "[name=" + name + ", department=" + department + ", age=" + age + "]";
	}

}





























/* Original attempt but it only prints out ordered by age
		 class Employees implements Comparator<Employees>, java.io.Serializable{
				private String name;
				private String department;
				private int age;
				Employees(){
				}
				Employees(String n, String d, int a){
					name = n;
					department = d;
					age = a;
				}
				public String getName(){
					return name;
				}
				public String getDepartment(){
					return department;
				}
				public int getAge(){
					return age;
				}
				public int compareTo (Employees first){
					return (this.name).compareTo(first.name);
				}
				
				public int compareTo1 (Employees first){
					return (this.department).compareTo(first.department);
				}
				
				public int compare (Employees first, Employees second){
						return first.age - second.age;
				}
		 	}
		  class Sort {
			 
			 public static void main(String args[]){
				 List<Employees> list = new ArrayList<Employees>();
				 list.add(new Employees("Cyril", "Accounting", 48));
				 list.add(new Employees("Pam", "Human Resources", 38));
				 //Collections.sort(list);
				// for(Employees first:list)
				//	 System.out.print(first.getName() + "	");
				
				 //By default is sorts based on age
				 
				 Collections.sort(list, new Employees());
				 System.out.println("");
				 for (Employees first:list)
					 System.out.println(first.getName() + ":" + first.getDepartment() + ":" +first.getAge());
				 
			 }
		 }
			*/