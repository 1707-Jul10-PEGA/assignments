package com.rb.driver;

import com.rb.users.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Driver {

    public static Scanner SCAN;
    
    public static Driver BANK_SYSTEM;
    
    public Bank theBank;

    public static void main(String[] args) {

        SCAN = new Scanner(System.in);

        BANK_SYSTEM = new Driver();

        BANK_SYSTEM.mainMenu();

        SCAN.close();
    }

    private void mainMenu() {

        boolean loop = true;

        theBank = Bank.getBank();

        User activeUser = null;

        do {

            if (activeUser == null) {
                activeUser = LoginMenu.logIn();
            } else {

                switch (activeUser.getAccess()) {
                case 0:
                    CustomerMenu.customerMenu((Customer) activeUser);
                    break;
                case 1:
                    EmployeeMenu.employeeMenu((Employee) activeUser);
                    break;
                case 2:
                    AdminMenu.adminMenu((Admin) activeUser);
                    break;
                default:

                    break;
                }

                System.out.println("Logging out.\n");
                if (activeUser.getAccess() == 2) {
                    System.out.println("Stop system?\n");
                    System.out.println("  1 - Continue");
                    System.out.println("  2 - Shut down");

                    int reply = 0;

                    try {
                        reply = SCAN.nextInt();
                    } catch (Exception e) {
                        // TODO add log here
                    } finally {
                        SCAN.nextLine();
                    }
                    if (reply == 2) {
                        loop = false;
                    }
                }
                activeUser = null;
            }

        } while (loop);
        
        // Serialize data
        
        String fileLocation = "src\\main\\resources\\bankOutput.txt";
        
        try{
            
            FileOutputStream fileOut = new FileOutputStream(fileLocation);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(theBank);
            out.close();
            fileOut.close();
            
            System.out.println("Status successfully saved");
        }catch(IOException e){
            // TODO error logging
        }
        
    }

}
