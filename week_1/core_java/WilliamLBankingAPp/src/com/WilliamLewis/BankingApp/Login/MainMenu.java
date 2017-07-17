package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
	JButton admin;
	JButton employee;
	JButton customer;

	JLabel welcome = new JLabel("Welcome to our bank, please select your role.");
	// JPanel panel = new JPanel();
	Container panel = getContentPane();

	public MainMenu(String username, String password, String role) {
		super("Welcome");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(3, 1));

		admin = new JButton("Admin");
		employee = new JButton("Employee");
		customer = new JButton("Customer");

		panel.add(admin);

		panel.add(employee);

		panel.add(customer);
		// button.setFont(new Font("Courier", Font.PLAIN, 36));
		setSize(1000, 1000);
		pack();
		setVisible(true);

		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (role.equalsIgnoreCase("admin")) {
					AdminPage admin = new AdminPage();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "I'm sorry, this account is not an admin account.");
				}
			}

		});
		employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (role.equalsIgnoreCase("employee")) {
					EmployeePage admin = new EmployeePage(username, password);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "I'm sorry, this account is not an Employee account.");
				}
			}

		});
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (role.equalsIgnoreCase("customer")) {
					CustomerPage admin = new CustomerPage(username, password);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "I'm sorry, this account is not an customer account.");
				}

			}

		});

	}
}