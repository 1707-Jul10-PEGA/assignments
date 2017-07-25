package com.rb.dao;

import java.sql.SQLException;
import java.util.List;

import com.rb.users.User;

public interface UserDao {
    
    User getUser(int id) throws SQLException;
    
    int getMostRecentUserID() throws SQLException;
    
    int saveUser(User user) throws SQLException;
    
    void updateUser(User user) throws SQLException;
    
    List<User> getAllUsers() throws SQLException;
    
    List<User> getAllUsersOfType(int type) throws SQLException;
    
    int deleteUser(int ... ids) throws SQLException;
    
    User login(String username, String password) throws SQLException;
    
}
