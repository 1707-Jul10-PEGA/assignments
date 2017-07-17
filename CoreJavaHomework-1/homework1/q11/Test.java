package q11;

import q11.Access.*;

public class Test {

	public static void main(String[] args) {
		AccessVariableDifferentPkg demo1 = new AccessVariableDifferentPkg();		
		System.out.println("The Value of the First Float is: " + demo1.decimal1);
		System.out.println("The Value of the Second Float is: " + demo1.decimal2);

	}

}
