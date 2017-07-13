package com.WL.q13;

public class Q13 {

	public static void main(String[] args) {
		
		String myBinary = "010101010101010101010101";
		String myBinaryShort = "0 1 ";
		String myBinary2 = "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1";
		for(int i = 0, j = 0; i < 5; i++){
			
				//Indexes are hit according to neighboring members of the sequence T_n = The summation of the first n integers
				//System.out.println(myBinary.substring(j, (j = j + i) ));
				//Doubled to account for spacing
				System.out.println(myBinary2.substring(j*2, 2*(j = j + i))+ "\n" );
				
				//System.out.println(myBinaryShort.substring((j*2)%4, (2*(j = j + i))%4 ));

			
	}

}

}
