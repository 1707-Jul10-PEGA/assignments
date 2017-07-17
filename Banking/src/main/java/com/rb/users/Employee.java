package com.rb.users;

import java.util.ArrayList;
import com.rb.accounts.*;
import static com.rb.driver.Driver.BANK_SYSTEM;


public class Employee extends User {

    /**
     * 
     */
    private static final long serialVersionUID = -513958991337598058L;

    ArrayList<Customer> customers;

    private final ArrayList<Customer> applicantQueue =
            new ArrayList<Customer>();

    private final ArrayList<Integer> appTypeQueue = new ArrayList<Integer>();

    Employee(String name, String password) {
        super(1, name, password);
    }

    void newCustomer(String name, String pass) {

        Customer newCust = new Customer(this, name, pass);

        customers.add(newCust);
        
        BANK_SYSTEM.theBank.addUser(newCust);

    }

    void addApplicant(Customer customer, Integer type) {
        applicantQueue.add(customer);
        appTypeQueue.add(type);
    }

    void viewApplications() {

        for (int i = 0; i < applicantQueue.size(); i++) {

            String output = "";

            output += (i + 1) + "  " + applicantQueue.get(i).toString()
                    + " wants to open a ";

            if (appTypeQueue.get(i) == 1) {
                output += "savings account";
            } else if (appTypeQueue.get(i) == 2) {
                output += "checking account";
            }

            System.out.println(output);
        }

    }

    void getApplication(int index) {
        String output = "";

        output += (index + 1) + "  " + applicantQueue.get(index).toString()
                + " wants to open a ";

        if (appTypeQueue.get(index) == 1) {
            output += "checking account";
        } else if (appTypeQueue.get(index) == 2) {
            output += "savings account";
        }

        System.out.println(output);
    }

    void appDecision(int index, boolean approved) {
        Customer customer = applicantQueue.get(index);
        Integer type = appTypeQueue.get(index);

        if (approved) {

            Account newAccount = null;

            if (type == 1) {
                newAccount = new Checking();
            } else if (type == 2) {
                newAccount = new Savings();
            } else {
                System.out.println("Error in account type");
            }

            if (newAccount != null) {
                customer.addAccount(newAccount);
                applicantQueue.remove(index);
                appTypeQueue.remove(index);
            }

        } else {
            applicantQueue.remove(index);
            appTypeQueue.remove(index);
        }
    }

    void printCustomers() {

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {

            String output = "";

            for (int i = 0; i < customers.size(); i++) {
                output += "  " + (i + 1) + " - " + customers.get(i).toString()
                        + "\n";
            }

            System.out.println(output);
        }

    }

}