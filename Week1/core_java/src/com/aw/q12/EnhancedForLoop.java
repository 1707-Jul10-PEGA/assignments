package com.aw.q12;

public class EnhancedForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = new int[10]; //Putting a number inside gets you to 100 faster. Default is 0 so add a loop
		
		for (int i = 0; i < list.length; i++) {
		//	if (i%2==0){
				list[i] = i;
	//		}
	//		else {
				//return;
	//		}
				
		}
		for (int i : list) {
			if (i%2==0){
			System.out.println(i);
		}
	}
}
}