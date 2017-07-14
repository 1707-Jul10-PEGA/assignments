package com.jntm.q18.driver;

public class Driver {

	public static void main(String[] args) {

		//call up the subclass
		Subclass x = new Subclass();

		//Test out the methods
		System.out.println(x.meth1("THere Are Both Cases herE."));//should be true
		System.out.println(x.meth1("only lowercase!")); // should be false

		System.out.println(x.meth2("this should become uppercase"));

		//I'm frankly not sure if this returns correctly.
		//It's definitely an integer, at least.
		System.out.println(x.meth3("No clue how this is gonna look!"));

	}

}
