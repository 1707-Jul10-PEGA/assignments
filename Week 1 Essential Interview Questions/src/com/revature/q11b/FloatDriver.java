package com.revature.q11b;
import com.revature.q11a.GiveFloats;
//in order to take from another package, the other variable must be public static
public class FloatDriver {
	public static void main(String[] args) {
		float tookThis = GiveFloats.takeThis;
		float tookThat = GiveFloats.takeThat;
		
		System.out.println("\"" + tookThis + "\"," + " \"" + tookThat + "\"");
	}

}
