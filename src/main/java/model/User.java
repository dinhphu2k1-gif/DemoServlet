package model;

public class User {
	private String email;
	private String passsword;
	
	public User() {
		
	}
	public User(String email, String passsword) {
		this.email = email;
		this.passsword = passsword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	
	
}
