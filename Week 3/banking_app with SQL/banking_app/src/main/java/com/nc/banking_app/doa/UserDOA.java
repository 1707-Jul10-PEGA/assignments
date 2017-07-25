package com.nc.banking_app.doa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDOA {
	public int getUserType(Connection conn, int userIndex){
		CallableStatement cstmt = null;
		int rs = 1;
		try {
			cstmt = conn.prepareCall("begin ? := GET_USER_TYPE(?); end;");
			cstmt.setInt(2, userIndex);
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.execute();
			rs = cstmt.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
