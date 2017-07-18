package com.wh.banking_app;

import java.io.Serializable;

public class User implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    
    private int ID;
    
    private String name;
    
    User(){}
    
    User(String name, int id){
	this.setName(name);
	this.setID(id);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getID() {
	return ID;
    }

    @Override
    public String toString() {
	return "User [ID=" + ID + ", name=" + name + "]";
    }

    public void setID(int id) {
	this.ID = id;
    }
}
