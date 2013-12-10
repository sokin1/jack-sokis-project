package org.jack.db;

import org.jack.controller.message.ControlMessage;

public class DBFacade {

	private static DBFacade instance = null;
	
	private DatabaseInterface dbInterface = DatabaseInterface.getInstance();
	
	private DBFacade() {
		
	}

	public static DBFacade getInstance() {
		if( instance == null ) {
			instance = new DBFacade();
		}
		return instance;
	}
	
	public void sendRequest( ControlMessage message ) {
		if( message.getType() == 10 ) {
			dbInterface.getRequest( message );
		}
	}
}
