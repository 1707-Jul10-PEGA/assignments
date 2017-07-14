package com.wh.q13;

/**
 * 
 * Q13. Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this.
 * 
 * @author Wei Huang
 *
 */
public class Q13 {
    public static void main(String[] args) {
	String str = "";
	int i = 0;
	int j = 0;
	boolean right = true;
	while (i < 4) {
	    if (right) {
		str += j + " ";
		j++;
		right = false;
	    } else {
		if (j >= 2) {
		    j = 0;
		}
		str = j + " " + str;
		right = true;
	    }
	    System.out.println(str);
	    i++;
	}
    }
}
