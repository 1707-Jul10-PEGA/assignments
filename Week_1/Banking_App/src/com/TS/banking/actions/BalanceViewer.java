package com.TS.banking.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.TS.banking.pojo.Storage;

public class BalanceViewer {
	public static String viewBalance(String user) throws IOException
	{
		File searchFile = new File("BalanceInfo.txt");
		int balanceInfoFields = 0;
		BufferedReader br = new BufferedReader(new FileReader(searchFile));
		String tokenizedString;
	
		try {
		    String line = br.readLine();

		    while (line != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line);
				while (tokenizer.hasMoreTokens())
				{
					tokenizedString = tokenizer.nextToken();
					if(balanceInfoFields == 0 && ("unlooked".equals(tokenizedString) || "denied".equals(tokenizedString)))
					{
						break;
					}
					if(balanceInfoFields == 1 && !user.equals(tokenizedString))
					{
						balanceInfoFields = 0;
						break;
					}
					/*balance fields initializing sequence*/
					if(balanceInfoFields == 1)
					{ 
						Storage.userID = user; 
					}
					if(balanceInfoFields == 2)
					{ Storage.firstName = tokenizedString; }
					if(balanceInfoFields == 3)
					{ Storage.lastName = tokenizedString; }
					if(balanceInfoFields == 4)
					{ Storage.money = Double.valueOf(tokenizedString); }
					
					balanceInfoFields += 1;
					if(!tokenizer.hasMoreTokens())
					{
						return Storage.print();
					}
				}

		        line = br.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			br.close();
		}
		return "No account balance associated with this user\n";
	}
}
