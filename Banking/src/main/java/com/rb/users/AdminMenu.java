package com.rb.users;

import java.util.ArrayList;

import com.rb.driver.Bank;

public class AdminMenu extends Menu {

    public static void adminMenu(Admin admin) {

        boolean loggedIn = true;

        do {

            int mainMenuInput = -1;
            int subMenuInput = -1;
            int thirdMenuInput = -1;
            
            ArrayList<User> userGroup;

            System.out.println("Choose an action:");
            System.out.println("  1 - View/Edit customer accounts");
            System.out.println("  2 - View/Edit Employee accounts");
            System.out.println("  3 - Create new employee/admin account");
            System.out.println("  0 - Log out");

            mainMenuInput = readInput();

            switch (mainMenuInput) {
            case 1:
                
                userGroup = Bank.getAllUsers(0);
                
                System.out.println("Which customer do you want to view?");
                
                userDisplay(userGroup);
                
                subMenuInput = readInput();
                
                if (subMenuInput > 0 && subMenuInput <= userGroup.size()){
                    
                    Customer customer = (Customer)userGroup.get(subMenuInput - 1);
                
                    customerEdit(customer);
                }else{
                    // TODO logging and error
                }
                break;
                
            case 2:
                
                userGroup = Bank.getAllUsers(1);
                
                System.out.println("Which employee do you want to view?");
                
                userDisplay(userGroup);
                
                subMenuInput = readInput();
                
                if (subMenuInput > 0 && subMenuInput <= userGroup.size()){
                    
                    Employee employee = (Employee)userGroup.get(subMenuInput - 1);
                
                    employeeEdit(employee);
                }else{
                    // TODO logging and error
                }
                break;
                
            case 3:
                
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

    
    private static void customerEdit(Customer customer) {
        // TODO Auto-generated method stub
        
    }
    
    private static void employeeEdit(Employee employee) {
        // TODO Auto-generated method stub
        
    }
    
    private static void userDisplay(ArrayList<User> userGroup) {
        
        if (userGroup.isEmpty()) {
            System.out.println("No accounts found. Please apply.");
        } else {

            String output = "";

            for (int i = 0; i < userGroup.size(); i++) {
                output += "  " + (i + 1) + " - " + userGroup.get(i).toString()
                        + "\n";
            }

            System.out.println(output);
        }
        
    }
    
}
