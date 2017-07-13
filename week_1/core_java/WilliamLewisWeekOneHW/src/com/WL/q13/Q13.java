package com.WL.q13;

public class Q13 {
	public static int binaryCount = 0;
	public static void main(String[] args) {

		printTriangle(4);
	}
	
	//Helper method that flips the binary count each time it is called
		public static void binaryIterate()
		{
			binaryCount = (binaryCount + 1)%2;
			return;
		}
		/**
		 * 
		 * @param Number of lines of spaced binary you wish to print
		 */
		public static void printTriangle(int lines)
		{
			for(int i = 0; i < lines; i++){
				//String to hold the current line to be printed
				StringBuffer thisLine = new StringBuffer();
				//nestled loop to increment the number of calls to binaryIterate as needed
				for(int j = lines; j >= lines - i; j--)
				{
					thisLine.append(binaryCount + " ");
					binaryIterate();
				}
				System.out.println(thisLine + "\n");
				
			}
		

}

}
