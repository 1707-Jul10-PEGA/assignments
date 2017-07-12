package com.nc.q13;

public class Q13 {
	public static void main(String[] args) {
		int flag = 0;
		for(int x = 1; x <= 4; x++)
		{
			for(int y = 1; y <= x; y++)
			{
				if(flag == 0)
				{
					System.out.print(flag);
					flag = 1;
				}
				else
				{
					System.out.print(flag);
					flag = 0;
				}
			}
			System.out.print("\n");
		}
	}
}
