package com.aw.bank_app.driver;

import java.io.IOException;
import java.io.Serializable;

public class Client implements Serializable{
	public String cUsername = "";
	public String cPassword = "";
	public boolean cStatus;
	public double cBalance;
	public String cRole; 
	
	public Client(){
		
	}
	public Client(String u, String p, boolean s, double b, String r){
		cUsername = u;
		cPassword = p;
		cStatus = s;
		cBalance = b;
		cRole = r;
	}
	public String deserialize(){
		return cUsername+":"+cPassword+":"+cStatus+":"+cBalance+":"+cRole+":";
	}
	public String getUser(){
		return cUsername;
	}
	public String getPass(){
		return cPassword;
	}
	public double getBalance(){
		return cBalance;
	}
	public String getcRole(){
		return cRole;
	}
	public void ModifyCash(double d){
		cBalance += d;
		try {
			MainMenu.SuccessfulTransaction(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
