package com.rb.dao;

import java.sql.SQLException;
import java.util.List;

import com.rb.accounts.Account;

public interface AccountDao {
    
    Account getAccount(int id) throws SQLException;
    
    int getMostRecentAccountID() throws SQLException;
    
    int saveAccount(Account account) throws SQLException;
    
    void updateAccount(Account account) throws SQLException;
    
    List<Account> getAllAccounts() throws SQLException;
    
    List<Account> getCustomersAccounts(int owner) throws SQLException;
    
    int deleteAccount(int ... ids) throws SQLException;
    
}
