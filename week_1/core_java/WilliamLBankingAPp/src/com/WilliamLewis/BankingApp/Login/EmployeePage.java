package com.WilliamLewis.BankingApp.Login;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Users.Employee;

public class EmployeePage extends JFrame{
	
	JButton home;
	Container panel = getContentPane();
	
	
	public EmployeePage(String empName, String password, String role){
		super("Accounts");
		Employee myEmployee = BankData.getInstance().getEmployee(empName, password);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(10, 10));
		JButton accountButton;
		String myPass = "employee" + ":" + empName + ":" + password;	
		
		
		for(Account acc : myEmployee.copyOfAccountList())
		{
			accountButton = new JButton(acc.getAccountHolder() + " 's Account");
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AccountPage accpage = new AccountPage(acc.getAccountHolder(), myPass);
					dispose();
					
				}
			});
		}
		for(AccountApplication aa : myEmployee.pendingApplications)
		{
			accountButton = new JButton(aa.getAccountHolder().getUsername() + " 's Account Application");
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AccountApplicationPage accpage = new AccountApplicationPage(aa.getAccountHolder());
					//dispose();
					
				}
			});
		
		}
		home = new JButton("Back");
		panel.add(home);
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainMenu back = new MainMenu(empName, password, role);
				dispose();
			}
		});
		pack();
		setVisible(true);
		
	}

}
