package com.rb.users;

public final class Admin extends User {
	
	/**
     * 
     */
    private static final long serialVersionUID = -7878577218555640580L;


    public Admin(String name, String password){
		super(0, name, password);
	}

    public Admin(String name, String password, int id){
        super(0, name, password, id);
    }

    void customerEdit(Customer customer) {
        // TODO Auto-generated method stub
        
    }
	
	
	
	
	
	
}
