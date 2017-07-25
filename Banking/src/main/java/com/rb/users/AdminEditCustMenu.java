package com.rb.users;

import java.util.ArrayList;
import java.util.List;

import com.rb.accounts.Account;
import com.rb.accounts.Checking;
import com.rb.accounts.Savings;

public class AdminEditCustMenu extends Menu {

    static void customerEdit(Admin admin, Customer customer) {
        // TODO Auto-generated method stub
        boolean loggedIn = true;
        
        do {
            
            int mainMenuInput = -1;
            int subMenuInput = -1;
            double amount = -1.0;
            
            System.out.println("Choose an action:\n  1 - Add funds");
            System.out.println("  2 - Remove funds");
            System.out.println("  3 - Create a new account\n");
            System.out.println("  0 - Log out");
            
            mainMenuInput = readInput();
            
            List<Account> accounts = new ArrayList<Account>();
            
            switch(mainMenuInput){
            case 1:
                
                System.out.println("Which account do you want " 
                        + "to add funds to?");
                accounts = customer.printAccounts();
                
                subMenuInput = readInput() - 1;

                System.out.println("How much are you adding?");
                
                amount = readAmount();
                
                
                if (subMenuInput < 0 || subMenuInput >= accounts.size()
                        || amount <= 0.0) {
                    
                } else {
                    accounts.get(subMenuInput).changeBalance(admin, amount);
                }
                break;
            
            case 2:
                
                System.out.println("Which account do you want " 
                    +"to remove funds from?");
                accounts = customer.printAccounts();
                
                subMenuInput = readInput() - 1;
                
                System.out.println("How much would you like to remove?");
                
                amount = readAmount();
                
                
                if(subMenuInput < 0 || subMenuInput >= accounts.size()
                        || amount <= 0.0){
                    
                } else {
                    amount *= -1;
                    accounts.get(subMenuInput).changeBalance(admin, amount);
                }
                
                break;
                
            case 3:
                
                System.out.println("What type of account do you " 
                    + "want to create?\n\n  1 - Checking\n  "
                    + "2 - Savings\n  0 - Cancel");
                
                subMenuInput = readInput();
                
                if(subMenuInput == 0) {
                    break;
                }else if (subMenuInput == 1) {
                    new Checking(customer);
                }else if (subMenuInput == 2) {
                    new Savings(customer);
                }else{
                    // TODO error logging
                }
                break;
            
            case 0:
                System.out.println("Thank you. Goodbye.");
                loggedIn = false;
                break;
            
            default:
                System.out.println("Invalid input. Please try again.");
                break;
            }
        
        } while (loggedIn);
    }

}
