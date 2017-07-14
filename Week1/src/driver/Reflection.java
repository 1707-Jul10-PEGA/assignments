package driver;

import java.lang.reflect.Field;

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String var= "Foo";
		
		System.out.println("Value " + var);
		
		Class<String> string = String.class;
		try {
		Field field = string.getDeclaredField("value");
		field.setAccessible(true);
		field.set(var, "different".toCharArray());
		System.out.println("New value: " + var);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		Integer in = 1;
		
		System.out.println("value" + in);
		
		try {
			Field field = Integer.getDeclaredField("value");
			field.setAccessible(true);
			field.set(in, 2);
			System.out.println("New value: " + in);
		}
		catch(Exception 3) {
			
		}
	}

}
