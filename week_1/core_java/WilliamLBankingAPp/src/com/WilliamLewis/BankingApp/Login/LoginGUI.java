package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.JDBC.DoAs.UserImplementDOA;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.sql.SQLException;

/**
 * 
 * @author Unknown, this particular class was written elsewhere and refractored
 *         for my purposes.
 *
 */
public class LoginGUI extends JFrame {
	JButton blogin;
	JPanel loginpanel;
	JTextField txuser;
	JTextField pass;
	JButton newUSer;
	JLabel username;
	JLabel password;
	private static Logger log = Logger.getRootLogger();

	public LoginGUI() {
		super("Login Authentication");
		BankData.getInstance();

		blogin = new JButton("Login");
		loginpanel = new JPanel();
		txuser = new JTextField(15);
		pass = new JPasswordField(15);
		newUSer = new JButton("Create User");
		username = new JLabel("User - ");
		password = new JLabel("Pass - ");

		setSize(300, 210);
		setLocation(500, 280);
		loginpanel.setLayout(null);

		txuser.setBounds(70, 30, 150, 20);
		pass.setBounds(70, 65, 150, 20);
		blogin.setBounds(110, 100, 80, 20);
		newUSer.setBounds(92, 130, 110, 20);
		username.setBounds(20, 28, 80, 20);
		password.setBounds(20, 63, 80, 20);

		loginpanel.add(blogin);
		loginpanel.add(txuser);
		loginpanel.add(pass);
		loginpanel.add(newUSer);
		loginpanel.add(username);
		loginpanel.add(password);

		getContentPane().add(loginpanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usertxt = txuser.getText();
				String passtxt = pass.getText();
				if (usertxt.equals("") && passtxt.equals("")) {
					JOptionPane.showMessageDialog(null, "Please insert Username and Password");
				}

				try {
					int UserID = UserImplementDOA.getInstance().getUserIdOnLogin(usertxt, passtxt);
					log.info("Login info accepted!");
					dispose();
					MainMenu menu = new MainMenu(UserID);
				} catch (SQLException ee) {

					log.info("Invalid UserName and Password");
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
				}

			}});

		newUSer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUserBox user = new NewUserBox();
				dispose();

			}
		});
	}

}
