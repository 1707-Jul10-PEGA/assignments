package com.cg.q8;

public class StoreStringsDriver {
	public static void main(String[] args) {
		StoreStrings ss = new StoreStrings();

		String[] strings = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer",
				"billy", "did", "noon" };

		ss.createArrayList(strings);
		ss.checkStrings();
		ss.printStrings();
		ss.printNonPalidromes();
		ss.printPalidromes();
	}
}
