package com.WL.q18;
import java.util.Iterator;
//Less boring extension!
public class MyConcrete extends MyAbstract{


	@Override
	/**
	 * Checks a given string for uppercase letters. Hopefully the name was pretty self documenting.
	 */
	public boolean containsUpperCase(String str) {
		for(Character x: str.toCharArray())
		{
			if(Character.isUpperCase(x))
			{
				return true;
			}
		}
		return false;
	}


	/**
	 * Converts all LowerCase characters in the given string to uppercase characters.
	 * 
	 */
	public String convertLowerCase(String str) {
		StringBuilder mystr = new StringBuilder(str);
		for(int i = 0; i < mystr.length(); i++)
		{
			if(Character.isLowerCase(mystr.charAt(i)))
			{
				mystr.setCharAt(i, Character.toUpperCase(mystr.charAt(i)));
			}
		}
		return mystr.toString();
	}
	//Tried to use the iterator, Not good yet
/*	@Override
	public String convertLowerCase(String str) {
		Character[] myChars = str.toCharArray();
		Iterator<Character> myIt = myChars.iterator();
		while(myChars.hasNext())
		{
			Character s = myIt.next();
			if(s.isLowerCase());
			{
				s.toUpperCase();
			}
		}
		
	}*/
	@Override
	public Integer convertToIntWith10(String str) {
		int myVal = 10;
		
		for(Character x: str.toCharArray())
		{
			myVal = myVal + (x.charValue());
		}
		return myVal;
	}

	
}
