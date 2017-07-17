package com.nc.banking_app.actions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import com.nc.banking_app.users.Users;

public class LoadData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void fileToList(List<Users> myList) throws NumberFormatException, ClassNotFoundException, IOException {

		myList.clear();

		ObjectInputStream objectinputstream = null;
		FileInputStream streamIn = null;
		try {
			streamIn = new FileInputStream("final.txt");
			objectinputstream = new ObjectInputStream(streamIn);
			List<Users> readCase = (List<Users>) objectinputstream.readObject();
			myList.addAll(readCase);

		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			if (objectinputstream != null) {
				objectinputstream.close();
			}
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

		} catch (Exception ex) {
		} finally {
			if (oos != null) {
				oos.close();
			}
		}

	}

}
