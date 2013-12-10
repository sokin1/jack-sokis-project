package org.jack.server.core.wrapper;


import org.jack.server.controller.MoneyInfoController;
import org.jack.server.controller.MoneyPlanController;
import org.jack.server.controller.UserController;
import org.jack.server.controller.message.ControlMessage;
import org.jack.server.db.DBFacade;

/*
 * TODO: TCP connection should be made
 */
public class Server {

	private Acceptor acceptor;

	public void connectionInitialize() {
		// Connect to network and return connected socket
	}

	public void initialize() {
		connectionInitialize();

		acceptor = Acceptor.getInstance();
	}

	public Server() {
		// Open handshaking port

		initialize();
		if( accceptRequests() ) {
			sendResponse();
		} else {
			sendErrorMessage();
		}
	}
	
	private boolean accceptRequests(/*json_request*/) {
		ControlMessage message = acceptor.invokeController();
		if( message.getType() == 99 ) {
			return false;
		} else {
			return true;
		}
	}
	
	private void sendResponse() {
	}
	
	private void sendErrorMessage() {
	}
}
