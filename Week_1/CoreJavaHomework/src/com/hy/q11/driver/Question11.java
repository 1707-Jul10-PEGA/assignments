package com.hy.q11.driver;
import com.hy.q11ExamplePackage.driver.ExampleClass;

//write a program that would access two float variables from a class that exists in another package.
public class Question11 {
	private void printExampleClassFloat(){
		System.out.println(ExampleClass.getF1());
		System.out.println(ExampleClass.getF2());
	}
}
