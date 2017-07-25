package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rb.users.Admin;
import com.rb.users.Customer;
import com.rb.users.Employee;
import com.rb.users.User;
import com.rb.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

    Connection conn = null;
    
    public void setup(){
        
        conn = ConnectionFactory.getInstance().getConnection();
        
    }
    
    public UserDaoImpl(){
        setup();
    }
    
    @Override
    public User getUser(int id) throws SQLException {
        
        PreparedStatement pstmt = null;
        String sql = "select username, password, privliges FROM Users WHERE U_ID = ?";
        
        User user = null;
        
        
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);
        
        while (rs.next()){
            String name = rs.getString(1);
            String pass = rs.getString(2);
            int type = rs.getInt(3);
            
            switch (type) {
            case 0:
                user = new Admin(name, pass, id);
                break;
            case 1:
                user = new Employee(name, pass, id);
                break;
            case 2:
                user = new Customer(name, pass, id);
                break;
            default:
                break;
            }
        }
        
        return user;
    }
    
    @Override
    public int getMostRecentUserID() throws SQLException {
        Statement stmt = null;
        String sql = "select USER_ID.CURRVAL FROM DUAL";
        int id = 0;
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()){
            id = rs.getInt(1);
        }
        
        return id;
    }

    @Override
    public int saveUser(User user) throws SQLException {
        String sql = "insert into users(U_ID, username, password, privliges)" 
                + " values (0, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, user.getUserID());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());
        pstmt.setInt(4, user.getAccess());
        
        return pstmt.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        
        String sql = "update users set username=?, password=?, privliges=? where U_ID=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());
        pstmt.setInt(3, user.getAccess());
        pstmt.setInt(4, user.getUserID());
        
        pstmt.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Statement stmt = null;
        String sql = "select U_ID, username, password, privliges FROM Users";
        
        List<User> userList = new ArrayList<User>();
        
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String pass = rs.getString(3);
            int type = rs.getInt(4);
            
            switch (type) {
            case 0:
                userList.add(new Admin(name, pass, id));
                break;
            case 1:
                userList.add(new Employee(name, pass, id));
                break;
            case 2:
                userList.add(new Customer(name, pass, id));
                break;
            default:
                break;
            }
        }
        
        return userList;
    }
    
    @Override
    public List<User> getAllUsersOfType(int type) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "select U_ID, username, password FROM Users WHERE" 
                + " PRIVLIGES = ?";
        
        List<User> userList = new ArrayList<User>();
        
        
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, type);
        
        ResultSet rs = pstmt.executeQuery(sql);
        
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String pass = rs.getString(3);
            
            switch (type) {
            case 0:
                userList.add(new Admin(name, pass, id));
                break;
            case 1:
                userList.add(new Employee(name, pass, id));
                break;
            case 2:
                userList.add(new Customer(name, pass, id));
                break;
            default:
                break;
            }
        }
        
        return userList;
    }

    @Override
    public int deleteUser(int... ids) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public User login(String username, String password) throws SQLException {
        User user = null;
        PreparedStatement pstmt = null;
        String sql = "select U_ID, privliges FROM Users WHERE username = ? "
                + "AND password = ?";
        
        
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery(sql);
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                int type = rs.getInt(2);
                
                switch (type) {
                case 0:
                    user = new Admin(username, password, id);
                    break;
                case 1:
                    user = new Employee(username, password, id);
                    break;
                case 2:
                    user = new Customer(username, password, id);
                    break;
                default:
                    break;
                }
                
            }
        
        return user;
    }
    
    public boolean usernameOpen(String username) throws SQLException {
        
        boolean inUse = false;
        PreparedStatement pstmt = null;
        String sql = "select U_ID FROM Users WHERE username = ?";
        
        
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, username);
        
        ResultSet rs = pstmt.executeQuery(sql);
        
        if (rs.isBeforeFirst()){
            inUse = true;
        }
        
        return inUse;
    }
    
    public int linkEmployeeCustomer(Employee e, Customer c) throws SQLException {
        
        String sql = "insert into customer_employee_table(Customer_ID, Employee_ID)" 
                + " values (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setInt(1, c.getUserID());
        pstmt.setInt(2, e.getUserID());
        
        return pstmt.executeUpdate();
    }
    
    public List<Customer> getEmployeeCustomers(Employee e) throws SQLException {
        
        List<Customer> custList = new ArrayList<Customer>();
        
        PreparedStatement pstmt = null;
        String sql = "select Customer_ID FROM Users WHERE Employee_ID = ?";
        
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setInt(1, e.getUserID());
        
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            
            custList.add((Customer) getUser(rs.getInt(1)));
            
        }
        
        return custList;
    }
    
}
