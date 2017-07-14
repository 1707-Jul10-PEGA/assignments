package q03;
class String_reverse {


	public static void main(String[] args){
		
		String my_str = "hello world";
	
		
		for(int i = 0;i < my_str.length(); i++){
			my_str = my_str.substring(0,i) + my_str.substring(my_str.length()-1) + my_str.substring(i,my_str.length()-1);
		}
				
		
		System.out.println(my_str);
	}
	
}
