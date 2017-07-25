package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rb.accounts.Account;
import com.rb.accounts.Checking;
import com.rb.accounts.Savings;
import com.rb.users.Customer;
import com.rb.users.Employee;
import com.rb.util.ConnectionFactory;

import static com.rb.driver.Driver.USER_DAO;

public class AccountDaoImpl implements AccountDao {

    
    Connection conn = null;
    
    public void setup(){
        
        conn = ConnectionFactory.getInstance().getConnection();
        
    }
    
    public AccountDaoImpl(){
        setup();
    }
    
    
    
    @Override
    public Account getAccount(int id) throws SQLException {
        
        PreparedStatement pstmt = null;
        String sql = "select balance, type, status, U_ID FROM Users WHERE ACC_ID = ? AND Status < 2";
        
        Account account = null;
        
        
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);
        
        while (rs.next()){
            double balance = rs.getDouble(1);
            int type = rs.getInt(2);
            int status = rs.getInt(3);
            int ownerID = rs.getInt(4);
            
            Customer owner = (Customer) USER_DAO.getUser(ownerID);
            
            switch (type) {
            case 1:
                account = new Savings(balance, status, id, owner);
                break;
            case 2:
                account = new Checking(balance, status, id, owner);
                break;
            default:
                break;
            }
        }
        
        return account;
    }

    @Override
    public int getMostRecentAccountID() throws SQLException {
        
        Statement stmt = null;
        String sql = "select ACCOUNT_ID.CURRVAL FROM DUAL";
        int id = 0;
        
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                id = rs.getInt(1);
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return id;
    }

    @Override
    public int saveAccount(Account account) throws SQLException {
        String sql = "insert into users(ACC_ID, balance, U_ID, type, status)" 
                + " values (0, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, account.getBalance());
        pstmt.setInt(2, account.getOwner().getUserID());
        pstmt.setInt(3, account.getType());
        pstmt.setInt(4, account.getStatus());
        
        return pstmt.executeUpdate();
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        String sql = "update users(balance, U_ID, type, status)" 
                + " values (?, ?, ?, ?) WHERE ACC_ID = ?";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, account.getBalance());
        pstmt.setInt(2, account.getOwner().getUserID());
        pstmt.setInt(3, account.getType());
        pstmt.setInt(4, account.getStatus());
        
        pstmt.setInt(5, account.getAccountID());
        
        pstmt.executeUpdate();
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException {
        Statement stmt = null;
        String sql = "select ACC_ID, U_ID, balance, type, status FROM Accounts WHERE status < 2";
        
        List<Account> accountList = new ArrayList<Account>();
        
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()){
            int id = rs.getInt(1);
            int ownerID = rs.getInt(2);
            double balance = rs.getDouble(3);
            int type = rs.getInt(4);
            int status = rs.getInt(5);
            
            Customer owner = (Customer) USER_DAO.getUser(ownerID);
            
            switch (type) {
            case 1:
                accountList.add(new Savings(balance, status, id, owner));
                break;
            case 2:
                accountList.add(new Checking(balance, status, id, owner));
                break;
            default:
                break;
            }
        }
        
        return accountList;
    }

    @Override
    public List<Account> getCustomersAccounts(int ownerID) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "select ACC_ID, balance, type, status FROM Accounts WHERE U_ID=? AND Status = 1";
        
        List<Account> accountList = new ArrayList<Account>();
        
        
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setInt(1, ownerID);
        
        ResultSet rs = pstmt.executeQuery(sql);
        
        while (rs.next()){
            int id = rs.getInt(1);
            double balance = rs.getDouble(2);
            int type = rs.getInt(3);
            int status = rs.getInt(4);
            
            Customer owner = (Customer) USER_DAO.getUser(ownerID);
            
            switch (type) {
            case 1:
                accountList.add(new Savings(balance, status, id, owner));
                break;
            case 2:
                accountList.add(new Checking(balance, status, id, owner));
                break;
            default:
                break;
            }
        }
        
        return accountList;
    }
    
    public List<Account> getApplications(Employee e) throws SQLException{
        PreparedStatement pstmt = null;
        String sql = "select Customer_ID FROM CUSTOMER_EMPLOYEE_TABLE WHERE EMPLOYEE_ID=?";
        
        List<Account> accountList = new ArrayList<Account>();
        
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setInt(1, e.getUserID());
        
        ResultSet rs = pstmt.executeQuery(sql);
        
        while (rs.next()){
            int id = rs.getInt(1);
            
            String sql2 = "select ACC_ID FROM ACCOUNTS WHERE U_ID = ? AND STATUS = 0";
            
            PreparedStatement pstmt2 = null;
            
            pstmt2 = conn.prepareStatement(sql2);
            
            pstmt2.setInt(1, id);
            
            ResultSet rs2 = pstmt2.executeQuery(sql2);
            
            while (rs2.next()){
                accountList.add(getAccount(rs2.getInt(1)));
            }
        }
        
        return accountList;
    }
    
    @Override
    public int deleteAccount(int... ids) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
