package q2Fibonacci;

public class Fibonacci {
	public static int fibCalc(int limit)
	{
		if (limit == 0 || limit == 1)
		{
			return limit;
		}
		else
		{
			return fibCalc(limit - 1) + fibCalc(limit - 2);	
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Hello! I'll calculate the first 25 numbers in the Fibonacci sequence. Here goes...");
		for(int x = 0; x < 25; x++)
		{
		 System.out.print(fibCalc(x) + " ");	
		}
	}
}
