package org.jack.core;

import org.jack.controller.UserController;
import org.jack.controller.message.ControlMessage;
import org.jack.controller.message.UserControlMessage;

public class Acceptor {

	private static Acceptor instance = null;

	public Acceptor() {
	}

	public static Acceptor getInstance() {
		if( instance == null ) {
			instance = new Acceptor();
		}
		return instance;
	}

	/*
	 * TODO: Need to separate into smaller subroutines
	 */
	public ControlMessage invokeController() {
		// Figure out which controller to be called from json input.

		UserController userController = UserController.getInstance();
		UserControlMessage userControlMessage = new UserControlMessage( 10, "Jack", "sokin1@Hotmail.com", "wornr123" );
		
		return userController.createUser( userControlMessage );
	}
}
