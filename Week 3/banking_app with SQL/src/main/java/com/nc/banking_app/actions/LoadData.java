package com.nc.banking_app.actions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.nc.banking_app.driver.Driver;
import com.nc.banking_app.users.UserFactory;
import com.nc.banking_app.users.Users;

public class LoadData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Driver.class);
	private static UserFactory userFactory = new UserFactory();

	public void fileToList(List<Users> myList) throws NumberFormatException, ClassNotFoundException, IOException {

		myList.clear();

		ObjectInputStream objectinputstream = null;
		FileInputStream streamIn = null;
		try {
			streamIn = new FileInputStream("final.txt");
			objectinputstream = new ObjectInputStream(streamIn);
			List<Users> readCase = (List<Users>) objectinputstream.readObject();
			myList.addAll(readCase);
			logger.debug("After f2l: \n" + myList.toString());

		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			if (objectinputstream != null) {
				objectinputstream.close();
			}
		}
		if(myList.isEmpty()){
			Users newUser = userFactory.getType("Admin", "Naim", 0.0, 0);
			myList.add(newUser);
			newUser = userFactory.getType("Employee", "Chau", 0.0, 0);
			myList.add(newUser);
		}
	}

	public void listToFile(List<Users> myList) throws IOException {

		PrintWriter writer = new PrintWriter("final.txt");
		writer.print("");
		writer.close();
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("final.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(myList);
			logger.debug("After l2f: \n" + myList.toString());

		} catch (Exception ex) {
		} finally {
			if (oos != null) {
				oos.close();
			}
		}

	}

}
