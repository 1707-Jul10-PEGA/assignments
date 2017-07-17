package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.Users.Admin;
import com.WilliamLewis.BankingApp.Users.Customer;
import com.WilliamLewis.BankingApp.Users.Employee;
import com.WilliamLewis.BankingApp.Users.User;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewUserBox extends JFrame {
	JButton create;
	JPanel newUserPanel;
	JTextField txuserer;
	JTextField passer;
	JComboBox petList;
	Container panel = getContentPane();

	public NewUserBox() {
		super("Registration");

		create = new JButton("Create");

		txuserer = new JTextField(15);
		passer = new JPasswordField(15);
		String[] petStrings = { "admin", "employee", "customer"};
		petList  = new JComboBox(petStrings);
		petList.setSelectedIndex(2);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(3, 2));

		
		panel.add(txuserer);
		panel.add(create);
		panel.add(passer);
		panel.add(petList);
		
		txuserer.setText("UserName");
		passer.setText(" ");
		pack();
		setVisible(true);
		Writer writer = null;
		File check = new File("userPass.txt");
		if (check.exists()) {

			// Checks if the file exists. will not add anything if the file does
			// exist.
		} else {
			try {
				File texting = new File("userPass.txt");
				writer = new BufferedWriter(new FileWriter(texting));
				writer.write("message");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("userPass.txt");
					Scanner scan = new Scanner(file);
					;

					FileWriter filewrite = new FileWriter(file, true);

					String usertxter = " ";
					String passtxter = " ";
					String roletxter = " ";
					String punamer = txuserer.getText();
					String ppaswder = passer.getText();
					String role = "" + petList.getSelectedItem();
					while (scan.hasNext()) {
						String[] temp = scan.nextLine().split(":");
						usertxter = temp[0];
						passtxter = temp[1];
						roletxter = temp[2];
					}

					if (punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
						JOptionPane.showMessageDialog(null, "Username is already in use");
						txuserer.setText("");
						passer.setText("");
						txuserer.requestFocus();

					} else if (punamer.equals("") && ppaswder.equals("")) {
						JOptionPane.showMessageDialog(null, "Please insert Username and Password");
					} else {
						//Split string by : instead
						filewrite.write(punamer + ":" + ppaswder + ":" + role + "\r\n");
						filewrite.close();
						makeUser(punamer, ppaswder, role);
						JOptionPane.showMessageDialog(null, "Account has been created.");
						dispose();
						LoginGUI log = new LoginGUI();

					}
				} catch (IOException d) {
					d.printStackTrace();
				}

			}
		});
	}
	public void makeUser(String user, String pass, String role)
	{
		switch(role.toLowerCase())
		{
		case "admin": 
		{
			new Admin(user, pass);
		}
			break;
		case "employee":
			new Employee(user, pass);
			break;
		case "customer":
			new Customer(user, pass);
			break;
		}
	}

}
