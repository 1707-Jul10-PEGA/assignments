package q06;

public class Even_or_odd {

	public static void main(String[] args){
		int b;
		String even_or_odd;
		for(int i=0;i<10;i++){
			b = i & 1;
			if(b == 1){
				even_or_odd = "odd";
			}else
				even_or_odd = "even";
			System.out.println(i + " :  " + even_or_odd);
				
		}
		
	}
}
