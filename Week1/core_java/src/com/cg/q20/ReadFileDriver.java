package com.cg.q20;

public class ReadFileDriver {
	public static void main(String[] args) {
		String location = "/Users/carlosgastelum/Documents/Revature/assignments/Week1/core_java/src/com/cg/q20/Data.txt";
		
		ReadFile read = new ReadFile(location);
		
		read.openFile();
		read.displayFileContent();
	}
}
