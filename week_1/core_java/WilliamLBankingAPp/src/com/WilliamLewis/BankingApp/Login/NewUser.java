package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewUser extends JFrame {
  JButton create;
  JPanel newUserPanel;
  JTextField txuserer;
  JTextField passer;


  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);

    //Set options for creating account type.
//    JPanel typePanel = new JPanel();
//    typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
//    
//    newUserPanel.add(typePanel);
 String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

  //Create the combo box, select item at index 4.
  //Indices start at 0, so 4 specifies the pig.
  JComboBox petList = new JComboBox(petStrings);
  petList.setSelectedIndex(4);
  
  newUserPanel.add(petList);


    
    setSize(300,200);
    setLocation(500,280);
    newUserPanel.setLayout (null); 


    txuserer.setBounds(70,30,150,20);
    passer.setBounds(70,65,150,20);
    create.setBounds(110,100,80,20);

    newUserPanel.add(create);
    newUserPanel.add(txuserer);
    newUserPanel.add(passer);

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
    File file = new File("userPass.txt");
    Scanner scan = new Scanner(file);;

      FileWriter filewrite = new FileWriter(file, true);

      String usertxter = " ";
      String passtxter = " ";
      String punamer = txuserer.getText();
      String ppaswder = passer.getText();
      while (scan.hasNext()) {
        usertxter = scan.nextLine();
        passtxter = scan.nextLine();
      }

        if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          txuserer.setText("");
          passer.setText("");
          txuserer.requestFocus();

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
        filewrite.close();
        JOptionPane.showMessageDialog(null,"Account has been created.");
        dispose();
        LoginGUI log = new LoginGUI();



        }
        } catch (IOException d) {
      d.printStackTrace();
    }

      }
    });
  } 

}
