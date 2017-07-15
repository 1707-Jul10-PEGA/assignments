package com.cg.q13;

public class Triangle {
	
	/*Print triangle uses a flag to 
	 * Alternate between 1 and 0
	 */
	public void printTriangle(int n){
		boolean onOff = false;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				if(onOff){
					System.out.print("1");
					onOff = false;
				}else{
					System.out.print("0");
					onOff = true;
				}
			}
			System.out.println();
		}
	}
}
