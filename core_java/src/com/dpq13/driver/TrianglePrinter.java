package com.dpq13.driver;

public class TrianglePrinter {
	
	boolean gate;

	public TrianglePrinter() {
		this.setGate(false);
	}

	public boolean isGate() {
		return gate;
	}

	public void setGate(boolean gate) {
		this.gate = gate;
	}
	
	public void printT() {
		for(int x = 1; x <= 4; x++) {
			String line = "";
			for(int y = 1; y <= x; y++) {
				if(this.isGate()) {
					line += "1 ";
					this.setGate(false);
				}
				else {
					line += "0 ";
					this.setGate(true);
				}
			}
			System.out.println(line);
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		TrianglePrinter tp = new TrianglePrinter();
		tp.printT();
	}
}
