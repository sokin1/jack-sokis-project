package org.jack.server.core.wrapper;


import org.jack.server.controller.MoneyInfoController;
import org.jack.server.controller.MoneyPlanController;
import org.jack.server.controller.UserController;
import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;
import org.jack.server.db.DBFacade;

import java.io.*;
import java.net.*;

/*
 * TODO: TCP connection should be made
 */
public class Server {

	private Acceptor acceptor = Acceptor.getInstance();

	private ServerSocket welcomeSocket;
	private Socket connectionSocket;

	private BufferedReader request;
	private DataOutputStream response;

	public void connectionInitialize() throws Exception {
		// Connect to network and return connected socket
		welcomeSocket = new ServerSocket( 6789 );
		while( true ) {
			connectionSocket = welcomeSocket.accept();

			request = new BufferedReader( new InputStreamReader( connectionSocket.getInputStream() ) );
			response = new DataOutputStream( connectionSocket.getOutputStream() );

			acceptRequests();
		}
	}

	public Server() {
		acceptor.setServer( this );
		// Open handshaking port
		try {
			connectionInitialize();
		} catch( Exception e ){
			sendErrorMessage(
				// Form error message to let clients know server issue
				new ResponseControlMessage()
			);
		}
	}

	private void acceptRequests(/*json_request*/) {
		acceptor.invokeController();
	}

	private void sendResponse( ResponseControlMessage response ) {
	}

	private void sendErrorMessage( ResponseControlMessage response ) {
	}
}
