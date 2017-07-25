package com.rb.users;

import static com.rb.driver.Driver.LOG;

import java.util.List;

import com.rb.accounts.Account;

public class EmployeeMenu extends Menu {

    public static void employeeMenu(Employee employee) {

        boolean loggedIn = true;

        do {

            int mainMenuInput = -1;
            int subMenuInput = -1;
            int thirdMenuInput = -1;

            System.out.println("Choose an action:\n  1 - View Applications");
            System.out.println("  2 - View Your Customers");
            System.out.println("  3 - Create new customer account");
            System.out.println("  0 - Log out");

            mainMenuInput = readInput();

            switch (mainMenuInput) {
            case 1:
                
                List<Account> applications = employee.viewApplications();

                System.out.print("Choose option number to select account: ");

                subMenuInput = readInput();

                if (subMenuInput >= 0 && subMenuInput < applications.size()) {

                    Account approve = applications.get(subMenuInput - 1);
                    
                    approve.toString();
                    
                    System.out.println("Approve this account?");
                    System.out.println("  1 - Yes\n  2 - No");

                    thirdMenuInput = readInput();
                    
                    if (thirdMenuInput == 1) {
                        employee.appDecision(approve, true);
                    } else if (thirdMenuInput == 2) {
                        employee.appDecision(approve, false);
                    } else {
                        System.out.println("Invalid selection.");
                    }

                }

                break;

            case 2:

                System.out.println(
                        "Which customer's accounts do you want to view?");
                List<Customer> customers = employee.printCustomers();
                
                subMenuInput = readInput() - 1;

                if (subMenuInput < 0) {
                    // TODO error and log
                } else if (subMenuInput >= customers.size()) {
                    // TODO error and log
                } else {

                    Customer viewing = customers.get(subMenuInput);

                    System.out.println(
                            "Here are " + viewing.getName() + "'s accounts");
                    viewing.printAccounts();
                }

                break;

            case 3:

                String name;
                String password;

                System.out.println("Thank you for choosing us!");

                name = readUsername();

                password = readPassword();

                employee.newCustomer(name, password);

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

}
