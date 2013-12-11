package org.jack.server.dto.user;

public class UserInputDTO {

	public int type;
	public String email;
	public String password;
	public String name;
	
	// For signup
	public UserInputDTO( int type, String email, String password, String name ) {
		this.type = type;
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	// For login, retrieve information, and update information
	public UserInputDTO( int type, String email, String password ) {
		this.type = type;
		this.email = email;
		this.password = password;
		this.name = "";
	}
	
	// For logout
	public UserInputDTO( int type, String email ) {
		this.type = type;
		this.email = email;
		this.password = "";
		this.name = "";
	}
}
