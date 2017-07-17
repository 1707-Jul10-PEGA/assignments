package com.rb.users;

import static com.rb.driver.Driver.LOG;

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
                
                employee.viewApplications();

                System.out.print("Choose option number to select account: ");

                subMenuInput = readInput();

                if (subMenuInput >= 0 && subMenuInput < employee.appQueueSize()) {

                    employee.getApplication(subMenuInput - 1);

                    System.out.println("Approve this account?");
                    System.out.println("  1 - Yes\n  2 - No");

                    thirdMenuInput = readInput();
                    
                    if (thirdMenuInput == 1) {
                        employee.appDecision(subMenuInput - 1, true);
                    } else if (thirdMenuInput == 2) {
                        employee.appDecision(subMenuInput - 1, false);
                    } else {
                        System.out.println("Invalid selection.");
                    }

                }

                break;

            case 2:

                System.out.println(
                        "Which customer's accounts do you want to view?");
                employee.printCustomers();

                subMenuInput = readInput() - 1;

                if (subMenuInput < 0) {
                    // TODO error and log
                } else if (subMenuInput >= employee.customers.size()) {
                    // TODO error and log
                } else {

                    Customer viewing = employee.customers.get(subMenuInput);

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
