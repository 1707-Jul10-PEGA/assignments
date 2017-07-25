package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;

import com.WilliamLewis.BankingApp.JDBC.DoAs.UserImplementDOA;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class NewUser extends JFrame {
  JButton create;
  JPanel newUserPanel;
  JTextField txuserer;
  JTextField passer;


  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);

    
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





    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

      String userName = txuserer.getText();
      String passWord = passer.getText();
      
      
      try {
			int UserID = UserImplementDOA.getInstance().getUserIdOnLogin(userName, passWord);
			JOptionPane.showMessageDialog(null, "I'm sorry, that username is already taken, please try again");
			txuserer.setText("");
			passer.setText("");
			txuserer.requestFocus();
			
		} catch (SQLException ee) {

			dispose();
			MainMenu menu = new MainMenu(UserID);
	
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
