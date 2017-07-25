package com.wh.banking_appTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.wh.banking_app.ConnectionFactory;

public class ConnectionFactoryTest {

    @Test
    public void connectionTest() {
	Connection conn = ConnectionFactory.getInstance().getConnection();
	try {
	    assertFalse(conn.isClosed());
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
