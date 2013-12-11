package org.jack.server.controller;


import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;
import org.jack.server.controller.message.UserControlMessage;
import org.jack.server.core.data.user.User;
import org.jack.server.db.DBFacade;

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

	public ControlMessage doAction( ControlMessage message ) {
		switch( message.getType() ) {
			case ControlMessage.CREATE_USER:
			case ControlMessage.LOGIN_USER:
			case ControlMessage.LOGOUT_USER:
			case ControlMessage.UPDATE_USER:
			case ControlMessage.REMOVE_USER:
			case ControlMessage.RETRIEVE_USER:
				
			case ControlMessage.CREATE_MONEY:
			case ControlMessage.UPDATE_MONEY:
			case ControlMessage.REMOVE_MONEY:
			case ControlMessage.RETRIEVE_MONEY:
	
			case ControlMessage.CREATE_PLAN:
			case ControlMessage.UPDATE_PLAN:
			case ControlMessage.REMOVE_PLAN:
			case ControlMessage.RETRIEVE_PLAN:
		}
		return new ResponseControlMessage();
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
			return new ResponseControlMessage();
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
