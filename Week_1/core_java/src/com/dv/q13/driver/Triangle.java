package com.dv.q13.driver;

public class Triangle {

	public static void main(String[] args) {
	
		// the rows will be 'i'; columns will be 'j'
		// begin at 1 so the nested loop has at least one iteration
		
		int rows = 4;
		int out = 0;
		for(int i=1; i<=rows; i++) {

			for(int j=0; j<i; j++) {
				System.out.print(out+" ");
				out=++out%2;
			}
			System.out.println();
		}
		
	}

}
