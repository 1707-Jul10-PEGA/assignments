package com.wh.banking_app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;

public class ListManager {
    private static Logger Log = Logger.getRootLogger();
    private static ArrayList<Application> applicationList = new ArrayList<Application>();
    private static HashMap<String, User> userMap = new HashMap<String,User>();
    private static HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
    
    public static void addApplication(Application application){
	applicationList.add(application);
    }
    
    public static Application getApplication(){
	if(!applicationList.isEmpty()){
	    Application application = applicationList.get(0);
	    applicationList.remove(0);
	    return application;
	} return null;
    }
    
    public static void addUser(User user){
	userMap.put(user.getName(), user);
    }
    
    public static User getUser(String user) {
	if(userMap.containsKey(user)){
	    return userMap.get(user);
	} else return null;
    }
    
    public static String getUserList() {
	return userMap.keySet().toString();
    }
    
    public static void addCustomer(Customer customer) {
	customerMap.put(customer.getName(), customer);
    }
    
    public static Customer getCustomer(String customer) {
	if(customerMap.containsKey(customer)){
	    return customerMap.get(customer);
	}else return null;
    }
    
    public static Set<String> getCustomerList() {
	return customerMap.keySet();
    }

    private static void setUserMap(HashMap<String, User> map){
	userMap = map;
    }
    
    private static void setCustomerMap(HashMap<String, Customer> map){
	customerMap = map;
    }
    
    private static void setApplicationList(ArrayList<Application> list){
	applicationList = list;
    }
    
    public static final boolean save() throws 
    java.io.IOException {
	try{
	    Log.info("Attempting to save.");
	    FileOutputStream fos = new FileOutputStream("UserList/customerMap");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(customerMap);
	    fos = new FileOutputStream("UserList/userMap");
	    oos = new ObjectOutputStream(fos);
	    oos.writeObject(userMap);
	    fos = new FileOutputStream("UserList/applicationList");
	    oos = new ObjectOutputStream(fos);
	    oos.writeObject(applicationList);
	    oos.close();
	    Log.info("Saved Successfully.");
	}catch(FileNotFoundException e){
	    Log.error("Failed to save.");
	    return false;
	}
	return true;
    }
    public static final boolean load() throws
    java.io.IOException {
	try{
	    Log.info("Attempting to Load.");
	    FileInputStream fis = new FileInputStream("UserList/customerMap");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    @SuppressWarnings("unchecked")
	    HashMap<String, Customer> temp = (HashMap<String, Customer>) ois.readObject();
	    setCustomerMap(temp);
	    fis = new FileInputStream("UserList/userMap");
	    ois = new ObjectInputStream(fis);
	    @SuppressWarnings("unchecked")
	    HashMap<String, User> temp2 = (HashMap<String, User>) ois.readObject();
	    setUserMap(temp2);
	    fis = new FileInputStream("UserList/applicationList");
	    ois = new ObjectInputStream(fis);
	    @SuppressWarnings("unchecked")
	    ArrayList<Application> temp3 = (ArrayList<Application>) ois.readObject();
	    setApplicationList(temp3);
	    ois.close();
	    Log.info("Loaded Successfully.");
	    return true;
	}catch(FileNotFoundException | ClassNotFoundException e){
	    Log.error("Failed to load.");
	    return false;
	}
    }
}
