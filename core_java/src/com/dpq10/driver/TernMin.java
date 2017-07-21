package com.dpq10.driver;

public class TernMin {
	
	private double x;
	private double y;

	public TernMin() {
		x = 1.0;
		y = 2.0;
	}
	
	public TernMin(Number x, Number y) {
		this.setX(x.doubleValue());
		this.setY(y.doubleValue());
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double findMin() {
		if (this.getX() < this.getY()) {
			return this.getX();
		}
		else {
			return this.getY();
		}
	}
	
	public static void main(String[] args) {
		TernMin tm = new TernMin();
		System.out.println(tm.findMin());
	}
}
