package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "FLASH_CARD", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement stmt = conn.createStatement();

			String insertSQL = "insert into flash_cards (fc_question, fc_answer) values("
					+ "'Is this an interesting quesiton?', 'No')";

			stmt = conn.createStatement();

			insertSQL = "select * from flash_cards";

			ResultSet rs = stmt.executeQuery(insertSQL);

			while (rs.next()) {

				System.out.println("Id is: " + rs.getInt(1));
				System.out.println("Question is: " + rs.getString(2));
				System.out.println("Answer is: " + rs.getString(3));

			}

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
