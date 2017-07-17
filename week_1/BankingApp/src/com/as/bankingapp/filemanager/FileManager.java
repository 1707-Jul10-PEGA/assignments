package com.as.bankingapp.filemanager;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.as.bankingapp.user.User;

/*
 * Class to read and write objects to and from files given
 * the filename and a list to write them to.
 */
public class FileManager {

	public static void readInUsers(String filename, List<User> l) {
		try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename))) {
			
			User user = (User) fileIn.readObject();
			while(true) {
				l.add(user);
				user = (User) fileIn.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	public static void readInAccounts(String filename, List<Account> l) {
//		try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename))) {
//			Account account = (Account) fileIn.readObject();
//			while (true) {
//				l.add(account);
//				account = (Account) fileIn.readObject();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (EOFException e) {
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void writeOutUsers(String filename, List<User> l) {
		try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (User u: l) {
				fileOut.writeObject(u);
			}
		} catch (IOException e) {
			
		}
	}
	
//	public static void writeOutAccounts(String filename, List<Account> l) {
//		try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filename))) {
//			for (Account a: l) {
//				fileOut.writeObject(a);
//			}
//		} catch (IOException e) {
//			
//		}
//	}
}
