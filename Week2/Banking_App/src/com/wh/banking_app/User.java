package com.wh.banking_app;

import java.io.Serializable;

public class User implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    
    private int password;
    
    private int id;
    
    private String name;
    
    public User(){}
    
    public User(String name, int password){
	this.setName(name);
	this.setPassword(password);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getPassword() {
	return password;
    }

    @Override
    public String toString() {
	return "User [password=" + password + ", name=" + name + "]";
    }

    public void setPassword(int password) {
	this.password = password;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
}
