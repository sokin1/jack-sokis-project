package org.jack.controller;


import org.jack.controller.message.ControlMessage;
import org.jack.controller.message.ResponseControlMessage;
import org.jack.controller.message.UserControlMessage;
import org.jack.db.DBFacade;
import org.jack.dto.user.User;

public class UserController extends ControllerBase {

	private static UserController instance = null;
	
	private DBFacade dbFacade = DBFacade.getInstance();
	
	User currentUser;

	public UserController() {
		currentUser = new User();
	}
	
	public static UserController getInstance() {
		if( instance == null ) {
			instance = new UserController();
		}
		return instance;
	}

	public UserController( User currentUser ) {
		this.currentUser = currentUser;
	}

	public void setUser( User currentUser ) {
		this.currentUser = currentUser;
	}
	
	public User getUser() {
		return currentUser;
	}
	
	public ControlMessage createUser( UserControlMessage message ) {
		if( validity( message ) ) {
			ResponseControlMessage responseMessage = dbFacade.sendRequest( message );
			return responseMessage;
		} else {
			//return new ResponseControlMessage( 100 );
		}

		
	}
	
	public boolean validity( UserControlMessage message ) {
		return true;
	}
	
	public User login( UserControlMessage message ) {
		return new User();
	}
	
	public void modifyUserInfo( UserControlMessage message ) {
		if( authenticateUser() ) {
			apply( message );
		} else {
			System.out.println( "Authentication failed" );
		}
	}
	
	private void apply( UserControlMessage message ) {
		
	}

	private boolean authenticateUser() {
		return true;
	}
}
