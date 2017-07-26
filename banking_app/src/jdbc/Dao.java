package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Dao {
	
	Connection conn = null;
	
	public void setup(){
		
		conn = ConnectionFactory.getInstance().getConnection();
		
	}
	
	public FlashCardDaoImpl(){
		
		setup();
		
	}

	public FlashCard getFlashCard(int id) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	public int saveFlashCard(FlashCard fc) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "insert into flash cards(fc_question, fc_answer) values(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, fc.getFC_QUESTION());
		pstmt.setString(2, fc.getFC_ANSWER());
		return pstmt.executeUpdate();
	
	}

	public void updateFlashCard(FlashCard fc) throws SQLException{
		// TODO Auto-generated method stub

	}

	public List<FlashCard> getAllFlashCards() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteFlashCard(int... ids) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

}