package com.MS.BankApp;

import java.io.BufferedWriter;
import com.MS.OJDBC.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.MS.BankApp.Application;
import com.MS.OJDBC.ConnectionFactory;
import com.MS.OJDBC.UserDAO;

public abstract class User implements functions{
	String privileges;
	String name;
	public static Scanner scan;
	
	/*
	 * Logs the user out. Calls the recordChanges function to save
	 * all changed data to the text document.
	 *
	 */
	public void logout() {
		// TODO Auto-generated method stub

		Application.logger.info("Logging out...\n");
		
		/*for(int i = 0; i<Application.newusercount;i++)
		{
			System.out.println("Read: privileges=" + Application.privlist[i] + " name=" + Application.namelist[i]
		    		   + " acctno=" + Application.acctlist[i] + " checking=" + Application.checlist[i] + " savings="
		    		   + Application.savlist[i] + " assignedto=" + Application.assignedto[i] + " request to open="
		    		   +Application.requests[i]);
		}*/
		this.recordChanges();
		Application.userid = 0;
		
		
	}

	/*
	 * Records the changes made before logging out and writes them back
	 * to the file "data.txt"
	 */
	private void recordChanges() {
		// TODO Auto-generated method stub
		/*String[] finaldat = new String[Application.newusercount];
		
		for(int i = 0; i<Application.newusercount; i++)
		{
			if("".equals(Application.namelist[i]))
			{
				//Customer not created yet
			}
			else
			{
			String savelinedata = Application.privlist[i].concat(":").concat(Application.namelist[i])
					.concat(":").concat(Application.savlist[i]).concat(":")
					.concat(Application.assignedto[i]).concat(":").concat(Application.requests[i]);
			
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
		*/
		
		Connection conn = null;
		Statement stmt = null;
		UserDAO dao = new UserDAO();
		conn = ConnectionFactory.getInstance().getConnection();
		for(int i = 0; i<Application.newusercount;i++)
		{
			try {
				dao.updateUser(Integer.toString(i+1), Application.namelist[i], Application.privlist[i], Application.acctlist[i],
				Application.checlist[i], Application.savlist[i], Application.assignedto[i], Application.requests[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
