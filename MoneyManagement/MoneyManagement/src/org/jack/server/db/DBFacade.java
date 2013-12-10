package org.jack.server.db;

import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;

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
	
	public ResponseControlMessage sendRequest( ControlMessage message ) {
		if( message.getType() == 10 ) {
			return dbInterface.getRequest( message );
		} else {
			return new ResponseControlMessage();
		}
	}
}
