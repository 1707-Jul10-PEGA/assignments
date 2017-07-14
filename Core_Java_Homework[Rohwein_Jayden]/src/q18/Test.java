package q18;

public class Test {


	public static void main(String[] args){
		
		Subclass my_sub = new Subclass();
		String my_str = "Hello World";
		
		System.out.println("String: Hello World");
		System.out.println("has Upper Case:" + my_sub.hasUpperCase(my_str));
		System.out.println("to upper case:" + my_sub.toUpper(my_str));

		my_str = "15";
		System.out.println("String: 15");;
		System.out.println("add 10 to Sting:"); 
		my_sub.addTenIntToPrint(my_str);
		
	}
	
}
