package com.dv.bankingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeApplicationRequest {

	private String fileName = "src/com/dv/bankingapp/apps.txt";
	
	public void writeAppRequest(ApplicationRequest appRequest) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(appRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeAppRequestList(List<ApplicationRequest> appRequestList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
		
			// write every application request in the list to the file
			for(ApplicationRequest ar : appRequestList) {
				oos.writeObject(ar);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ApplicationRequest readAppRequest() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			ApplicationRequest ar = (ApplicationRequest) ois.readObject();
			return ar;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ApplicationRequest> readAppRequestList() {
		boolean loop = true;
		List<ApplicationRequest> recoverAppRequestList = new ArrayList<ApplicationRequest>(); 
	
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
		
			// read users from file, add them to recoverUserList and return the list
			while(loop) {
			
				ApplicationRequest ar = (ApplicationRequest) ois.readObject();

				if(ar != null) {
					recoverAppRequestList.add(ar);
				}
				
				else {
					loop = false;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			Driver.serviceLog.eof("Reached end of file for apps.txt");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return recoverAppRequestList;
	}

}