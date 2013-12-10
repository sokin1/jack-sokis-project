package org.jack.controller.message;

public class UserControlMessage extends ControlMessage {

	private String name;
	private String id;
	private String password;
	
	public UserControlMessage( int type, String name, String id, String password ) {
		super( type );
		this.name = name;
		this.id = id;
		this.password = password;
	}

	/*
	 * For create account
	 */
	@Override
	public String getMessageForDB() {
		if( type == 1 ) {
			return name + ", " + id + ", " + password;
		} else {
			return "";
		}
	}
}
