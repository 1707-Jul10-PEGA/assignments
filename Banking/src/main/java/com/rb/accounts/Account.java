package com.rb.accounts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;

// import com.rb.driver.Bank;
import com.rb.users.Admin;
import com.rb.users.Customer;
import com.rb.users.User;
import com.rb.util.ConnectionFactory;

import static com.rb.driver.Driver.USER_DAO;
import static com.rb.driver.Driver.ACCOUNT_DAO;

public abstract class Account implements Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = -6083085257987681960L;

    private double interestRate;
	
	private int monthsSinceInterest;
	
	private double balance;
	
	private int type;
	
	private int accountID;
	
	private int status = 0;
	
	private Customer owner;
	
	public Account(){
		
	    Connection conn = ConnectionFactory.getInstance().getConnection();
	    
		this.balance = 0.0;
		this.monthsSinceInterest = 0;
		
		try{
		    conn.setAutoCommit(false);
		    ACCOUNT_DAO.saveAccount(this);
		    this.accountID = ACCOUNT_DAO.getMostRecentAccountID();
		} catch (SQLException e) {
		    e.printStackTrace();
		    try{
		        conn.rollback();
		    } catch (SQLException except) {
		        except.printStackTrace();
		    }
		}finally{
		    try{
		        conn.setAutoCommit(true);
		    }catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		//this.accountID = Bank.getNEXT_ACCOUNT_ID();
	}
	
	public Account(double balance, int status, int id, Customer owner) {
        // TODO Auto-generated constructor stub
	    this.monthsSinceInterest = 0;
	    this.accountID = id;
	    this.balance = balance;
	    this.setStatus(status);
	    this.owner = owner;
    }

    public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getType() {
		return type;
	}
	
	protected void setType(int type){
		this.type = type;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public boolean withdraw(double amount) {
		calcInterest();
		if (amount > balance) {
			System.out.println("Transaction denied: insufficient funds");
			return false;
		} else if (amount > 0) {
		    
		    Connection conn = ConnectionFactory.getInstance().getConnection();
		    
		    boolean done = false;
		    
		    try{
		        conn.setAutoCommit(false);
		        balance -= amount;
		        ACCOUNT_DAO.updateAccount(this);
		        System.out.format("You withdrew %.2f, your balance is now %.2f.%n",
		                amount, balance);
		        done = true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        balance += amount;
		        done = false;
		        try{
		            conn.rollback();
		        } catch (SQLException except) {
		            except.printStackTrace();
		        }
		    }finally{
		        try{
	                conn.setAutoCommit(true);
	            }catch (SQLException e) {
	                e.printStackTrace();
	            }
		    }
		    return done;
		} else{
			System.out.println("Transaction denied: invalid amount");
			return false;
		}
	}
	
	public boolean deposit(double amount){
		calcInterest();
		if (amount > 0) {
		    Connection conn = ConnectionFactory.getInstance().getConnection();
            
            boolean done = false;
            
            try{
                conn.setAutoCommit(false);
                balance += amount;
                ACCOUNT_DAO.updateAccount(this);
                System.out.format("You withdrew %.2f, your balance is now %.2f.%n",
                        amount, balance);
                done = true;
            } catch (SQLException e) {
                e.printStackTrace();
                balance -= amount;
                done = false;
                try{
                    conn.rollback();
                } catch (SQLException except) {
                    except.printStackTrace();
                }
            }finally{
                try{
                    conn.setAutoCommit(true);
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return done;
		} else {
			System.out.println("Transaction denied: invalid amount");
			return false;
		}
	}
	
	public void calcInterest(){
		double interest = balance * interestRate * monthsSinceInterest;
		balance += interest;
	}
	
	public String toString() {
		
		String output = "Account type: ";
		NumberFormat form = NumberFormat.getCurrencyInstance();
		
		if (type == 2) {
			output += "Savings   ";
		} else if(type == 1) {
			output += "Checking  ";
		} else {
			// TODO logging
			return "I'm sorry, an error occurred. Account improperly created";
		}
		
		output += "Account ID: " + accountID + "  Balance: " + form.format(balance);
		
		return output;
		
	}

    public void changeBalance(Admin admin, double amount) {
        
        int adminID = admin.getUserID();
        
        User adminCheck = null;
        try {
            adminCheck = USER_DAO.getUser(adminID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (adminCheck != null){
            if(adminCheck.getAccess() == 0){
                Connection conn = ConnectionFactory.getInstance().getConnection();
                
                try{
                    conn.setAutoCommit(false);
                    balance += amount;
                    ACCOUNT_DAO.updateAccount(this);
                    System.out.format("You withdrew %.2f, your balance is now %.2f.%n",
                            amount, balance);
                    // TODO log
                } catch (SQLException e) {
                    e.printStackTrace();
                    balance -= amount;
                    try{
                        conn.rollback();
                    } catch (SQLException except) {
                        except.printStackTrace();
                    }
                }finally{
                    try{
                        conn.setAutoCommit(true);
                    }catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}