package org.jack.server.dto.user;

import org.jack.server.dto.RequestData;

/* category USER :
	 * 		type SIGNUP :
	 * 	data : {
	 * 		name  	 : [name of new user],
	 * 		email 	 : [email address of new user(require validity check)],
	 * 		password : [password(password check is done in client's side)]
	 *  }
	 *  	type Login :
	 *   data : {
	 *   	email	 : [],
	 *   	password : []
	 *   }
	 *   	type Logout :
	 *   data : {
	 *   	email	 : []
	 *   }
	 *   	type remove :
	 *   data : {
	 *   	name	 : [],
	 *   	email	 : [],
	 *   	password : []
	 *   }
	 */
public class UserInputDTO extends RequestData {

	private String email = "";
	private String password = "";
	private String name = "";
	
	// For signup
	public UserInputDTO( String email, String password, String name ) {
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	// For login, retrieve information, and update information
	public UserInputDTO( String email, String password ) {
		this.email = email;
		this.password = password;
	}
	
	// For logout
	public UserInputDTO( String email ) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
}
