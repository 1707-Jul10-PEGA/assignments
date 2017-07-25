package com.rb.users;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import com.rb.util.ConnectionFactory;

import static com.rb.driver.Driver.USER_DAO;

public abstract class User implements Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = -173966185103445604L;

    private String name;
	
	private String password;
	
	private int access;
	
	private int userID;	
	
	
	
	User(int access, String name, String password){
		
		Connection con = ConnectionFactory.getInstance().getConnection();

		this.name = name;
		this.password = password;
		this.access = access;
		
		try {
		    con.setAutoCommit(false);
            USER_DAO.saveUser(this);
            this.userID = USER_DAO.getMostRecentUserID();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            try{
                con.rollback();
            } catch (SQLException except) {
                except.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}

	public User(int access, String name, String password, int id) {
	    this.userID = id;
        this.name = name;
        this.password = password;
        this.access = access;
    }

    public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}


	public int getAccess() {
		return access;
	}


	public int getUserID() {
		return userID;
	}
	
	public String toString(){
	    
	    return "User: " + name + "  Access level: " + access + "  User ID: " 
	            + userID;
	    
	}
	
}
