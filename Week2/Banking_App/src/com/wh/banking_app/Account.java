package com.wh.banking_app;

public interface Account {
    public double withdraw(double amount);
    public boolean deposit(double amount);
    public double viewBalance();
    public boolean transfer(double amount, Account a);
    public String status();
    public boolean approve();
    public boolean deny();
}
