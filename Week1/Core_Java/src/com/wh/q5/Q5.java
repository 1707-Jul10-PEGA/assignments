package com.wh.q5;

/**
 * Write a substring method that accepts a string str and an integer idx and
 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
 * o fthe existing substring methods in the String, StringBuilder, or
 * StringBuffer APIs.
 * 
 * @author Wei Huang
 *
 */
public class Q5 {

	/**
	 * @param str
	 *            string to be subString.
	 * @param idx
	 *            index of where to end the subString.
	 * @return the subString of str.
	 */
	private static String subString(String str, Integer idx) {
		char[] temp = new char[idx];
		for (int i = 0; i < idx; i++) {
			temp[i] = str.charAt(i);
		}
		String answer = new String(temp);
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(subString("ThisIsATest", 6));
	}

}
