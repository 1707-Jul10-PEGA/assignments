package com.HL.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question20
{
	public static void main(String[] args) throws IOException
	{
		String myFile = "C:\\Users\\hungl\\Desktop\\Revature bootcamp\\Data.txt";
        String line = "";
        String fileSplitBy = ":";

        try (BufferedReader br = new BufferedReader(new FileReader(myFile)))
        {
        	while ((line = br.readLine()) != null)
        	{
                String[] newStr = line.split(fileSplitBy);
                System.out.println("Name: " + newStr[0] + " "+newStr[1]+"\nAge: "+newStr[2]+" years\nState: "+newStr[3]+" State\n");
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
}
