package com.aq.q11.driver;

import com.aq.q11_2.driver.ParentFloat;

public class GetRemoteFloat{
	
	public static void main(String[] args) {
		ParentFloat objective = new ParentFloat(5.0f,6.0f);
		System.out.println(objective.getObjectiveOne());
		System.out.println(objective.getObjectiveTwo());
	}	
}
