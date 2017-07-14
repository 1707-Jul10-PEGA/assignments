package com.hy.q13.driver;

public class Question13 {
	private void displayTriangle(){

		int k = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < i; j++)
			{
				System.out.print(k + " ");
				k = k == 0 ? 1 : 0;			
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		new Question13().displayTriangle();
		
	}
}
