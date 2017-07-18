package com.wh.banking_app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Customer extends User{

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    
    private Account checkingAccount = new CheckingAccount();
    private Application application;
    
    public Customer(){}
    
    public Customer(String name, int id){
	setName(name);
	setID(id);
    }

    public void apply(){
	application = new Application(this);
	ListManager.addApplication(application);
    }
    
    public Application getApplication(){
	if(application != null){
	    return this.application;
	}else 
	    return null;
    }
    
    public void setApplication(Application application) {
	this.application = application;
    }

    @Override
    public String toString() {
	return "Customer [applicationStatus()=" + applicationStatus() + ", viewBalance()=" + viewBalance()
		+ ", getName()=" + getName() + "]";
    }

    public String applicationStatus() {
	if(application != null){
	    return application.status();
	}else{
	    return "NO APPLICATION";
	}
    }

    public double viewBalance() {
	if(application!=null && application.status().equals("APPROVED")){
	    return checkingAccount.viewBalance();
	}
	return -1;
    }

    public Account getCheckingAccount() {
	return checkingAccount;
    }
    
    public void setCheckingAccount(Account account) {
	checkingAccount = account;
    }

    public boolean deposit(double amount) {
	if(application!=null && application.status().equals("APPROVED")){
	    return checkingAccount.deposit(amount);
	}
	return false;
    }

    public double withdraw(double amount) {
	if(application!=null && application.status().equals("APPROVED")){
	    return checkingAccount.withdraw(amount);
	}
	return -1;
    }
    
    public final boolean save(String filename) throws 
    java.io.IOException {
	if (filename == null) {
	    filename = "Customers/"+getName() + getID();;
	}
	try{
	    FileOutputStream fos = new FileOutputStream(filename);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(this);
	    oos.close();
	}catch(FileNotFoundException e){
	    return false;
	}
	return true;
    }

    
    public final Customer restore(String filename)throws
    java.io.IOException {
    	if (filename == null) {
    		filename = "Customers/"+getName() + getID();
    	}
    	try{
    	    FileInputStream fis = new FileInputStream(filename);
    	    ObjectInputStream ois = new ObjectInputStream(fis);
	    Customer temp = (Customer) ois.readObject();
	    ois.close();
	    return temp;
    	}catch(FileNotFoundException | ClassNotFoundException e){
    		return null;
    	}
    }
}
