package com.rb.users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rb.accounts.Account;
import com.rb.accounts.Checking;
import com.rb.accounts.Savings;

import static com.rb.driver.Driver.LOG;
import static com.rb.driver.Driver.ACCOUNT_DAO;


public class Customer extends User {

    /**
     * 
     */
    private static final long serialVersionUID = 3918031600238817157L;
    
    Employee assignedTo;
    
  //  private ArrayList<Account> accounts;

    
    Customer(Employee assignedTo, String name, String password) {
        super(2, name, password);
        this.assignedTo = assignedTo;
  //      this.accounts = new ArrayList<Account>();
    }

    public Customer(String name, String pass, int id) {
        super(2, name, pass, id);
    }

    void apply(int accountType) {
        String log = getName() + " applied for a ";
        
        if(accountType == 1){
            log += "checking account ";
            new Checking(this);
        }else if(accountType == 2){
            log += "savings account ";
            new Savings(this);
        }
        
        LOG.trace(log + "and is waiting for " + assignedTo.getName() 
            + "'s approval");
        
        

    }

    

    List<Account> printAccounts() {
        
        List<Account> accounts = new ArrayList<Account>();
        try {
            accounts = ACCOUNT_DAO.getCustomersAccounts(getUserID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please apply.");
        } else {

            String output = "";

            for (int i = 0; i < accounts.size(); i++) {
                output += "  " + (i + 1) + " - " + accounts.get(i).toString()
                        + "\n";
            }

            System.out.println(output);
        }
        
        return accounts;
        
    }

    @Override
    public String toString() {

        return "Username: " + getName() + "Customer ID: " + getUserID()
                + "  Managing Employee " + assignedTo.toString();

    }

}
