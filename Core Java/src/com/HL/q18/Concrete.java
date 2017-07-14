package com.HL.q18;

public class Concrete extends ThreeMethods
{
	boolean method1(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			if(Character.isUpperCase(s.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}
	void method2(String s)
	{
		System.out.println(s.toUpperCase());
	}
	void method3(String s)
	{
		System.out.println(Integer.parseInt(s)+10);
	}
}
