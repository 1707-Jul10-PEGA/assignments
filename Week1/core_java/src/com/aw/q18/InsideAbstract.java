package com.aw.q18;



public class InsideAbstract extends SuperClass {
	@Override
    public boolean upperCaseCheck(String str) {
	char[] cArr = str.toCharArray();
	for (char c : cArr) {
	    if (65 <= c && c <= 90) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public String toUpperCase(String str) {
	return str.toUpperCase();
    }

    @Override
    public void plusTen(String str) {
	try {
	    Integer i = new Integer(str);
	    System.out.println(i + 10);
	} catch (NumberFormatException e) {
	    System.out.println("String is not an Integer");
	    // e.printStackTrace();
	}
    }
}

