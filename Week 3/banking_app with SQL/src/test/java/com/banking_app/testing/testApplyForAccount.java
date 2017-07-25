package com.banking_app.testing;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.nc.banking_app.actions.LoadData;
import com.nc.banking_app.actions.UserAction;
import com.nc.banking_app.users.Users;

public class testApplyForAccount {

	@Test
	public void test() throws IOException, NumberFormatException, ClassNotFoundException {
		UserAction test = new UserAction();
		int userIndex = 2;
		List<Users> myList = null;
		LoadData ld = new LoadData();
		ld.fileToList(myList);
		int output = (int) test.cApplyForAccount(myList, userIndex);
		assertEquals(-1, output);
	}

}
