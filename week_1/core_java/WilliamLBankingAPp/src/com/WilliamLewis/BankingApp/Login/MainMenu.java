package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;

import com.WilliamLewis.BankingApp.JDBC.DoAs.UserImplementDOA;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class MainMenu extends JFrame {
	JButton admin;
	JButton employee;
	JButton customer;
	JButton login;

	JLabel welcome = new JLabel("Welcome to our bank, please select your role.");
	// JPanel panel = new JPanel();
	Container panel = getContentPane();

	public MainMenu(Integer userID) {
		super("Welcome");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(3, 3));

		admin = new JButton("Admin");
		employee = new JButton("Employee");
		customer = new JButton("Customer");
		login = new JButton("Back");
		
		
		panel.add(login);
		panel.add(admin);
		panel.add(employee);
		panel.add(customer);
		// button.setFont(new Font("Courier", Font.PLAIN, 36));

		pack();
		setVisible(true);

		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int thisUser = 3;
				try {
					thisUser = UserImplementDOA.getInstance().getUserTypeOnID(userID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (thisUser == 0) {
					AdminPage admin = new AdminPage(userID);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "I'm sorry, this account is not an admin account.");
				}
			}

		});
		employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int thisUser = 3;
				try {
					thisUser = UserImplementDOA.getInstance().getUserTypeOnID(userID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (thisUser == 1) {
					EmployeePage admin = new EmployeePage(userID);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "I'm sorry, this account is not an Employee account.");
				}
			}

		});
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int thisUser = 3;
				try {
					thisUser = UserImplementDOA.getInstance().getUserTypeOnID(userID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (thisUser == 2) {
					CustomerPage admin = new CustomerPage(userID);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "I'm sorry, this account is not an customer account.");
				}

			}

		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					LoginGUI admin = new LoginGUI();
				} 


		});

	}
}