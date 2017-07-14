package q13;

public class Triagle {

	
	public static void main(String[] args){
		
		int tri_height = 4;
		int symbol = 0;
		
		
		for(int i = 0;i< tri_height;i++){
			
			for(int j = 0; j <= i;j++){
				System.out.print(symbol);
				symbol = (symbol -1)*-1;
			}
			System.out.print("\n");
		}
	}
}
