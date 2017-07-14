package q18;

public class Subclass extends SuperClass{
	
	public boolean hasUpperCase( String str){
		
		if(str.toLowerCase().equals(str))
			return false;
		
		return true;
		
		
	}	
	
	public String toUpper(String str){
		
		return str.toUpperCase();
	}
	
	
	public void addTenIntToPrint(String str){
		System.out.println( Integer.valueOf(str) + 10);
	}

}
