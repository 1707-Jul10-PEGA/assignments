//Carson Stephens

package com.cts.pojo;

public class Userpass
{
	private String username;
	private String type;
	
	public Userpass(String username, String type)
	{
		super();
		this.username = username;
		this.type = type;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
	
}
