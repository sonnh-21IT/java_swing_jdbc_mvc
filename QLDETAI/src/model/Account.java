package model;

public class Account {
	private String user, pass, Name;
	public Account() {
		
	}
	public Account(String user, String pass, String Name) {
		this.user = user;
		this.pass = pass;
		this.Name = Name;
	}
	
	public Account(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
