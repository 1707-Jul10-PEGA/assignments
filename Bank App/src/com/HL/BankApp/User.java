package com.HL.BankApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.HL.BankApp.Driver;

public abstract class User implements myMenu {
	String accountType;
	String name;
	public static Scanner scan;

	public void logout() {
		Driver.log.info("Signed out!\n");
		this.myRecord();
	}

	private void myRecord() {
		String[] mydata = new String[Driver.numOfUser];

		for (int i = 0; i < Driver.numOfUser; i++) {
			if ("".equals(Driver.nameList[i])) {

			} else {
				String tempdata = Driver.typeList[i].concat(";").concat(Driver.nameList[i]).concat(";")
						.concat(Driver.balanceList[i]).concat(";").concat(Driver.requests[i]);

				mydata[i] = tempdata;
			}
		}
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(Driver.file);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < mydata.length; i++) {
				bw.write(mydata[i]);
				bw.newLine();
			}

			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getaccountType() {
		return accountType;
	}

	public void setaccountType(String accountType) {
		this.accountType = accountType;
	}

}
