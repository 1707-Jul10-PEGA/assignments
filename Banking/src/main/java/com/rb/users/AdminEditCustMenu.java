package com.rb.users;

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
            System.out.println("  4 - Create a new account\n");
            System.out.println("  0 - Log out");
            
            mainMenuInput = readInput();
            
            switch(mainMenuInput){
            case 1:
                
                System.out.println("Which account do you want " 
                        + "to add funds to?");
                customer.printAccounts();
                
                subMenuInput = readInput() - 1;

                System.out.println("How much are you adding?");
                
                amount = readAmount();
                
                
                if (subMenuInput < 0 || subMenuInput >= customer.accountTotal()
                        || amount <= 0.0) {
                    
                } else {
                    customer.accessAccount(subMenuInput).changeBalance(admin, amount);
                }
                break;
            
            case 2:
                
                System.out.println("Which account do you want " 
                    +"to remove funds from?");
                customer.printAccounts();
                
                subMenuInput = readInput() - 1;
                
                System.out.println("How much would you like to remove?");
                
                amount = readAmount();
                
                
                if(subMenuInput < 0 || subMenuInput >= customer.accountTotal()
                        || amount <= 0.0){
                    
                } else {
                    amount *= -1;
                    customer.accessAccount(subMenuInput).changeBalance(admin, amount);
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
                    customer.addAccount(new Checking());
                }else if (subMenuInput == 2) {
                    customer.addAccount(new Savings());
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
