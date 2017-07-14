package com.revature.ddh.day2;


public class Planet {
	
	public String name;
	
	public Planet(String name) {
		
		this.name = name;
		
	}
	
	@Override
	public void finalize() {
		System.out.println("Planet" + name + " has been destoryed");
	}

}
