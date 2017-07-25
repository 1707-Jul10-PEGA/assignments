package com.wh.banking_app;

public class Admin extends User{

    /**
     * 
     */
    private static final long serialVersionUID = 28295476L;
    
    public Admin(){};
    
    public Admin(String name, int ID){
	setName(name);
	setPassword(ID);
    };

}
