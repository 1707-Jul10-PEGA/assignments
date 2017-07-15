package com.aw.q20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintFiles 
{
	public static void main(String[] args)
	{
		File targetFile = new File("C:/Users/Wong/Desktop/Data.txt");
		FileInputStream lin = null;
		String whateverIwant = "";
		String[] a ;

		try{
			lin = new FileInputStream(targetFile);
			int content;
			while((content = lin.read())!=-1)
			{
				whateverIwant += (char)content;			
			}
			//content = lin.read();
			//System.out.print(whateverIwant);
			a = whateverIwant.split(":");
			//System.out.println(Arrays.toString(a));
			String tempFirstName = "";
			String tempLastName = "";
			String age = "";
			String state = "";
			for(int x = 0; x <= a.length -1; x=x+4){
		        tempFirstName = a[x];
		        tempLastName = a[x+1];
		        age = a[x+2];
		        state = a[x+3];



		        System.out.println("Name: " + tempFirstName + " " + tempLastName);
		        System.out.println("Age: " + age);
		        System.out.println("State: " + state);
		        System.out.println("");
		}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		
	}
}
