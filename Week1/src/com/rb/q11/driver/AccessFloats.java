package com.rb.q11.driver;

// import data file from other package
import com.rb.q11.data.Data;

public class AccessFloats {

	public static void main(String[] args) {
		
		// read data from other class, print it out.
		System.out.println(Data.a);
		System.out.println(Data.b);
	}

}
