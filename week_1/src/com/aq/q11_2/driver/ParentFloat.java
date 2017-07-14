package com.aq.q11_2.driver;

public class ParentFloat {
	private float objectiveOne; 
	private float objectiveTwo;
	
	public float getObjectiveOne() {
		return objectiveOne;
	}
	public void setObjectiveOne(float objectiveOne) {
		this.objectiveOne = objectiveOne;
	}
	public float getObjectiveTwo() {
		return objectiveTwo;
	}
	public void setObjectiveTwo(float objectiveTwo) {
		this.objectiveTwo = objectiveTwo;
	}
	public ParentFloat(float objectiveOne, float objectiveTwo) {
		super();
		this.objectiveOne = objectiveOne;
		this.objectiveTwo = objectiveTwo;
	}
}
