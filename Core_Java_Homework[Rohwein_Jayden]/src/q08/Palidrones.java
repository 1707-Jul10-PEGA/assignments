package q08;
import java.util.*;

public class Palidrones {
	
	public static void main(String[] args){
		
		ArrayList<String> my_Strings = new ArrayList<String>();
		ArrayList<String> my_palidrones = new ArrayList<String>();
		
		my_Strings.add("karan");
		my_Strings.add("madam");
		my_Strings.add("tom");
		my_Strings.add("civic");
		my_Strings.add("radar");
		my_Strings.add("sexes");
		my_Strings.add("jimmy");
		my_Strings.add("kayak");
		my_Strings.add("john");
		my_Strings.add("refer");
		my_Strings.add("billy");
		
		String my_str = "";
		
		for(int i = 0;i<my_Strings.size();i++){
			
			my_str = my_Strings.get(i);
			for(int j = 0;j < my_str.length(); j++){
				my_str = my_str.substring(0,j) + my_str.substring(my_str.length()-1) + my_str.substring(j,my_str.length()-1);
			}
			if(my_Strings.get(i).equals(my_str))
				my_palidrones.add(my_str);
		}
		
		System.out.println(my_palidrones.toString());
		
		
		
		
		
		
		
		
	}

}
