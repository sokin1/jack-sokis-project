package org.jack.controller.message;

public class UserControlMessage extends ControlMessage {

	private String name;
	private String email;
	private String password;
	
	public UserControlMessage( int type, String name, String email, String password ) {
		super( type );
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserControlMessage( int type, String email, String password ) {
		super( type );
		this.email = email;
		this.password = password;
	}

	/*
	 * TODO: Should be fixed.( CREATE_USER works only )
	 */
	@Override
	public String getMessageForDB() {
		switch( type ) {
			case CREATE_USER:
				return name + ", " + email + ", " + password;
			case LOGIN_USER:
			case LOGOUT_USER:
				return email + ", " + password;
			case RETRIEVE_USER:
			case UPDATE_USER:
			case REMOVE_USER:
				return name + ", " + email + ", " + password;
			default:
				return "";
		}
		
	}
}
