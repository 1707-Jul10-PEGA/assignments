package com.md.q11;

import java.lang.reflect.Field;

import com.md.q11.testpackage.*;

public class PackageVisibility {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		PackageVisibilityHelper helper = new PackageVisibilityHelper();
		
		System.out.println(helper.getFloatvar1());
		System.out.println(helper.getFloatvar2());
	}
	
}
