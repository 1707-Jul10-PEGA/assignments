package com.revature.ddh.day2;

public class GarbageCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Planet alderan = new Planet("Alderaan");
		
		alderan = null;
		
		System.gc();
	
		for(int i = 0; i < 1000000; i++) {
			new Planet("planet #" + i);
			if (i%1000 ==0) {
			try {
				Thread.currentThread().sleep(100);
			
			} catch ( InterruptedException e) {
				e.printStackTrace();
			}
		}
	System.gc();

	}

  }
}
