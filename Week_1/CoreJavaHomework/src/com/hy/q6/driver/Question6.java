package com.hy.q6.driver;
//write a program to determine if an integer is even without %
public class Question6 {
	public boolean isEven(int i)
	{
		//variable i is even if it can be divided by 2 and then multiple by 2 again and will equal its original value
		int j = i/2;
		if(j*2 == i){
			return true;
		}
		return false;
	}
	
	public static final void main(String[] arg){
		System.out.println(new Question6().isEven(5));//odd
		System.out.println(new Question6().isEven(34));//even
		System.out.println(new Question6().isEven(120));//even
		System.out.println(new Question6().isEven(135));//odd

	}
}
