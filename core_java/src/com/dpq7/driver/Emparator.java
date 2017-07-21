package com.dpq7.driver;

import java.util.Comparator;

public class Emparator implements Comparator<Employee> {		//Employee-comparator get it?
	
	public Emparator() {
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		Employee e1 = o1;
		Employee e2 = o2;
		int score = 0;
		if (e1.getAge() < e2.getAge()) {
			score--;
		}
		else if (e1.getAge() > e2.getAge()) {
			score++;
		}
		if (e1.getName().compareTo(e2.getName()) < 0) {
			score--;
		}
		else if (e1.getName().compareTo(e2.getName()) > 0) {
			score++;
		}
		if (e1.getDepartment().compareTo(e2.getDepartment()) < 0) {
			score--;
		}
		else if (e1.getDepartment().compareTo(e2.getDepartment()) > 0) {
			score++;
		}
		score += e1.getName().compareTo(e2.getName());
		return score;
	}	
	
	public Employee[] sort(Employee e1, Employee e2) {
		Employee[] sorted = {e2, e1};
		if (this.compare(e1, e2) < 0) {
			return sorted;
		}
		else {
			sorted[0] = e1;
			sorted[1] = e2;
			return sorted;
		}
	}
	
	public static void main(String[] args) {
		Emparator imp = new Emparator();
		Employee e1 = new Employee();
		Employee e2 = new Employee("Zim", "Invader", 30);
		System.out.println(imp.compare(e1, e2));
		Employee[] emps = imp.sort(e1, e2);
		System.out.println(emps[0]);
		System.out.println(emps[1]);
	}
	
}
