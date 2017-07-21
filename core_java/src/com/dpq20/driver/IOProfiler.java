package com.dpq20.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IOProfiler {
	
	private FileReader fr;
	private BufferedReader br;

	public IOProfiler() {
		
		fr = null;
		br = null;
		
		try {
			fr = new FileReader("Data");
			br = new BufferedReader(fr);
			String current;
			while ((current = br.readLine()) != null) {
				String[] temp = this.format(current);
				this.print(temp);
			}
		} catch (IOException e) {
			System.out.println("Something's not right");
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public String[] format(String s) {
		String[] in;
		in = s.split(":");
		String[] out = new String[3];
		out[0] = "Name: " + in[0] + " " + in[1];
		out[1] = "Age: " + in[2] + " years";
		out[2] = "State: " + in[3] + " state";
		return out;
	}
	
	public void print(String[]s) {
		for(String x: s) {
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		IOProfiler iop = new IOProfiler();
	}
}
