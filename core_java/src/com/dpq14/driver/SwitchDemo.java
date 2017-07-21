package com.dpq14.driver;

import java.util.Date;

public class SwitchDemo {
	
	private int master;
	private String[] splits;

	public SwitchDemo() {
		master = 1;
	}
	
	public SwitchDemo(int in) {
		if (in > 3) {
			System.out.println("Input number lower than 3");
		}
		master = in;
	}
	
	public int getMaster() {
		return master;
	}

	public void setMaster(int master) {
		this.master = master;
	}

	public void doIt() {
		switch(master) {
			case 1:
				System.out.println(Math.sqrt(49));
				break;
			case 2:
				Date d = new Date();
				System.out.println(d);
				break;
			case 3:
				String s = "I am learning Core Java";
				this.splits = s.split(" ");
				for(String str: this.splits) {
					System.out.println(str);
				}
				break;
		}
	}
	
	public static void main(String[] args) {
		SwitchDemo dem = new SwitchDemo();
		dem.doIt();
		dem.setMaster(2);
		dem.doIt();
		dem.setMaster(3);
		dem.doIt();
	}
}
