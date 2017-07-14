package com.revature.ddh.question18;

public class UsePaper extends Paper {

	@Override
boolean upperCheck(String n) {
		// TODO Auto-generated method stub
		String x = n.toLowerCase();
		if (x.equals(n)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	String lowerConvert(String n) {
		// TODO Auto-generated method stub
		n.toUpperCase();
		return n;
	}

	@Override
	String stringInt(String n) {
		// TODO Auto-generated method stub
		
		int x = Integer.parseInt(n);
		x= x + 10;
		System.out.println(x);
		return null;
	}

	
	}


