package com.MS.BankApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.MS.BankApp.Application;

public abstract class User implements functions{
	String privileges;
	String name;
	public static Scanner scan;
	
	
	public void logout() {
		// TODO Auto-generated method stub

		Application.logger.info("Logging out...\n");
		this.recordChanges();
		
		
	}

	private void recordChanges() {
		// TODO Auto-generated method stub
		String[] finaldat = new String[Application.newusercount];
		
		for(int i = 0; i<Application.newusercount; i++)
		{
			if("".equals(Application.namelist[i]))
			{
				//Customer not created yet
			}
			else
			{
			String savelinedata = Application.privlist[i].concat(":").concat(Application.namelist[i])
					.concat(":").concat(Application.acctlist[i]).concat(":").concat(Application.checlist[i])
					.concat(":").concat(Application.savlist[i]).concat(":").concat(Application.requests[i]);
			
			finaldat[i] = savelinedata;
			}
		}
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try 
		{		
			fw = new FileWriter(Application.file);
			bw = new BufferedWriter(fw);


		
			for(int i=0;i<finaldat.length;i++)
			{
				bw.write(finaldat[i]);
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

}
