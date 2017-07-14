package com.nc.q19;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for(int x = 1; x <= 10; x++)
		{
			list1.add(x);
		}
		System.out.println(list1);
		
		for(int y = 0; y < 5; y++)
		{
			num = num + list1.get(y * 2 + 1);
		}
		System.out.println(num);
		num = 0;
		
		for(int y = 0; y < 5; y++)
		{
			num = num + list1.get(y * 2);
		}
		System.out.println(num);
		
		
		list1.remove(1);
		list1.remove(2);
		list1.remove(4);
		list1.remove(6);
		
		System.out.println(list1);
	}

}
