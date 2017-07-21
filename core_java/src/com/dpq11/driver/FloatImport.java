package com.dpq11.driver;

import com.dpq11b.driver.FloatStorage;

public class FloatImport {
	
	private float ix;
	private float iy;

	public FloatImport() {
		FloatStorage fs = new FloatStorage();
		this.setIx(fs.getX());
		this.setIy(fs.getY());
	}

	public float getIx() {
		return ix;
	}

	public void setIx(float ix) {
		this.ix = ix;
	}

	public float getIy() {
		return iy;
	}

	public void setIy(float iy) {
		this.iy = iy;
	}
	
	public static void main(String[] args) {
		FloatImport fi = new FloatImport();
		System.out.println(fi.getIx() + " " + fi.getIy());
	}
}
