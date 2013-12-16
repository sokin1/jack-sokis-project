package org.jack.server.dto.request;

public class UserRequestData extends RequestData {

	private String name = "";
	private String email = "";
	private String password = "";

	public UserRequestData() {
	}
	
	public UserRequestData( String name, String email, String password ) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserRequestData( String email, String password ) {
		this.email = email;
		this.password = password;
	}
	
	public UserRequestData( String email ) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
