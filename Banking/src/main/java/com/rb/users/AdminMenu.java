package com.rb.users;

import java.util.ArrayList;

import static com.rb.driver.Driver.BANK_SYSTEM;


public class AdminMenu extends Menu {

    public static void adminMenu(Admin admin) {

        boolean loggedIn = true;

        do {

            int mainMenuInput = -1;
            int subMenuInput = -1;
            
            String name = null;
            String password = null;
            
            ArrayList<User> userGroup;

            System.out.println("Choose an action:");
            System.out.println("  1 - View/Edit customer accounts");
            System.out.println("  2 - View/Edit Employee accounts");
            System.out.println("  3 - Create new employee account");
            System.out.println("  4 - Create new admin account");
            System.out.println("  0 - Log out");

            mainMenuInput = readInput();

            switch (mainMenuInput) {
            case 1:
                
                userGroup = BANK_SYSTEM.theBank.getAllUsers(0);
                
                System.out.println("Which customer do you want to view?");
                
                userDisplay(userGroup);
                
                subMenuInput = readInput();
                
                if (subMenuInput > 0 && subMenuInput <= userGroup.size()){
                    
                    Customer customer = (Customer)userGroup.get(subMenuInput - 1);
                
                    AdminEditCustMenu.customerEdit(admin, customer);
                }else{
                    // TODO logging and error
                }
                break;
                
            case 2:
                
                userGroup = BANK_SYSTEM.theBank.getAllUsers(1);
                
                System.out.println("Which employee do you want to view?");
                
                userDisplay(userGroup);
                
                subMenuInput = readInput();
                
                if (subMenuInput > 0 && subMenuInput <= userGroup.size()){
                    
                    Employee employee = (Employee)userGroup.get(subMenuInput - 1);
                
                    EmployeeMenu.employeeMenu(employee);
                }else{
                    // TODO logging and error
                }
                break;
                
            case 3:

                name = readUsername();

                password = readPassword();

                new Employee(name, password);

                System.out.println("Thank you, your account has been created.");
                
                break;
                
            case 4:
                
                name = readUsername();

                password = readPassword();

                new Admin(name, password);

                System.out.println("Thank you, your account has been created.");
                
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
    
    private static void userDisplay(ArrayList<User> userGroup) {
        
        if (userGroup.isEmpty()) {
            System.out.println("No accounts found.");
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
