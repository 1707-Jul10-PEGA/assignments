package com.TS.banking.resources;

import java.sql.SQLException;

import com.TS.banking.pojo.BalanceInfo;
import com.TS.banking.pojo.LoginInfo;

public interface BankingAppDao {
	boolean getBalanceInfo(String login, int task) throws SQLException;
	
	int insertBalanceInfo(String status, String login, String firstName, String lastName, Double money) throws SQLException;
	
	int deleteBalanceInfo(String login) throws SQLException;
	
	int updateBalanceInfo(String login, String newInfo, String field) throws SQLException;
	
	boolean getLoginInfo(String login, int task) throws SQLException;
	
	int insertLoginInfo(String login, String password, int role) throws SQLException;
	
	int deleteLoginInfo(String login) throws SQLException;
	
	int updateLoginInfo(String login, String newInfo, String field) throws SQLException;
	//Select, insert, delete, update
//	FlashCard getFlashCard(int id) throws SQLException;
//	
//	int saveFlashCard(FlashCard fc) throws SQLException;
//	
//	void updateFlashCard(FlashCard fc) throws SQLException;
//	
//	List<FlashCard> getAllFlashCards() throws SQLException;
//	
//	int deleteFlashCard(int ...id) throws SQLException;
}
