package com.rb.users;

import java.util.ArrayList;
import com.rb.accounts.Account;
import static com.rb.driver.Driver.LOG;

public class Customer extends User {

    /**
     * 
     */
    private static final long serialVersionUID = 3918031600238817157L;
    
    Employee assignedTo;
    
    private ArrayList<Account> accounts;

    
    Customer(Employee assignedTo, String name, String password) {
        super(0, name, password);
        this.assignedTo = assignedTo;
        this.accounts = new ArrayList<Account>();
    }

    void apply(int accountType) {
        String log = getName() + " applied for a ";
        
        if(accountType == 1){
            log += "checking account ";
        }else if(accountType == 2){
            log += "savings account ";
        }
        
        LOG.trace(log + "and is waiting for " + assignedTo.getName() 
            + "'s approval");
        
        assignedTo.addApplicant(this, accountType);

    }

    Account accessAccount(int index) {
        return accounts.get(index);
    }

    void printAccounts() {

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

    }

    void addAccount(Account account) {
        accounts.add(account);
    }
    
    int accountTotal(){
        return accounts.size();
    }

    @Override
    public String toString() {

        return "Username: " + getName() + "Customer ID: " + getUserID()
                + "  Managing Employee " + assignedTo.toString();

    }

}
