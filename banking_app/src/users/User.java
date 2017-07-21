package users;

public abstract class User {
	private String username;
	private String password;
	private String type;
	
	public User() {
		username = null;
		password = null;
	}
	
	public User(String un, String pw) {
		username = un;
		password = pw;
	}
	
	public User(String t, String un, String pw) {
		type = t;
		username = un;
		password = pw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
