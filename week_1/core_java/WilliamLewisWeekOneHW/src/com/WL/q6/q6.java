package com.WL.q6;

public class q6 {

	public static void main(String[] args) {
		//Determine if an integer is even.

		isEven(4);
		isEven(5);
		isEven(239829672);
		isEven(19841519);
		isEven(-19841519);
		isEven(-19841518);
	}
	
	public static boolean isEven(int myVal)
	{
		int temp = lastNumber(myVal);
		if(temp == 0 || temp == 2 || temp ==  4 || temp == 6 || temp == 8){
			System.out.println(myVal + " is Even!");
			return true;
		}
		else
		{
			System.out.println(myVal + " is Odd!");
			return false;
		}
		
		}
	public static int lastNumber(int myVal){
	    int myPlace = myVal / 10;
	    myPlace = myVal - myPlace * 10;
	    return myPlace;
	}

}
