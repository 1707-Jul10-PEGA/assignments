//package com.WilliamLewis.BankingApp.Serializers;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
//
//public class AccountDataSerializer {
//
//	public void writeAccount(Account p, String filename) {
//		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
//			oos.writeObject(p);
//			System.out.println("Successfully wrote object to file " + p);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public Account readAccount(String filename) {
//		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
//			Account Account = (Account) ois.readObject();
//			return Account;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//}
