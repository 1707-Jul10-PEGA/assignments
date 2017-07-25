package com.rb.users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rb.accounts.*;
import static com.rb.driver.Driver.BANK_SYSTEM;
import static com.rb.driver.Driver.LOG;
import static com.rb.driver.Driver.USER_DAO;
import static com.rb.driver.Driver.ACCOUNT_DAO;

public class Employee extends User {

    /**
     * 
     */
    private static final long serialVersionUID = -513958991337598058L;

  //  List<Customer> customers;

 /*   private final List<Customer> applicantQueue =
            new ArrayList<Customer>();

    private final List<Integer> appTypeQueue = new ArrayList<Integer>();
*/
    Employee(String name, String password) {
        super(1, name, password);
  //      customers = new ArrayList<Customer>();
    }

    public Employee(String name, String pass, int id) {
        super(1, name, pass, id);
    }

    void newCustomer(String name, String pass) {

        Customer newCust = new Customer(this, name, pass);

  //      customers.add(newCust);
        
    }

    List<Account> viewApplications() {
        
        List<Account> applicantQueue = new ArrayList<Account>();
        
        try{
            applicantQueue = ACCOUNT_DAO.getApplications(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < applicantQueue.size(); i++) {

            String output = "";

            output += (i + 1) + "  " + applicantQueue.get(i).getOwner().getName()
                    + " wants to open a ";

            System.out.println(output);
        }
        return applicantQueue;
    }
    
    void appDecision(Account approve, boolean approved) {

        if (approved) {
            
            approve.setStatus(1);
            try{
                ACCOUNT_DAO.updateAccount(approve);
                System.out.println(approve.toString() + " was approved");
            }catch (SQLException e){
                e.printStackTrace();
                approve.setStatus(0);
            }
        }else{
            approve.setStatus(2);
            try{
                ACCOUNT_DAO.updateAccount(approve);
                System.out.println(approve.toString() + " was denied");
            }catch(SQLException e){
                e.printStackTrace();
                approve.setStatus(0);
            }
        }
    }

    List<Customer> printCustomers() {
        
        List<Customer> customers = new ArrayList<Customer>();
        try {
            customers = USER_DAO.getEmployeeCustomers(this);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
        return customers;
    }

}