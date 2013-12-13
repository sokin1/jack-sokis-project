package org.jack.server.core.wrapper;

import org.jack.server.controller.MoneyInfoController;
import org.jack.server.controller.MoneyPlanController;
import org.jack.server.controller.UserController;
import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.MoneyInfoControlMessage;
import org.jack.server.controller.message.MoneyPlanControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;
import org.jack.server.controller.message.UserControlMessage;
import org.jack.server.dto.InMessage;
import org.jack.server.dto.OutMessage;

public class Acceptor {

	private static Acceptor instance = null;

	private UserController currentUser;
	private MoneyInfoController moneyInfo;
	private MoneyPlanController moneyPlan;
	
	private Server server;

	public Acceptor() {
		currentUser = UserController.getInstance();
		moneyInfo = MoneyInfoController.getInstance();
		moneyPlan = MoneyPlanController.getInstance();
	}
	
	public void setServer( Server server ) {
		this.server = server;
	}

	public Server getServer() {
		return server;
	}

	public static Acceptor getInstance() {
		if( instance == null ) {
			instance = new Acceptor();
		}
		return instance;
	}
	
	public void json_parser(/*json_request*/) {
		// parse json and form control message
		InMessage incomingMessage = new InMessage();
		
		initializeControlMessage( incomingMessage );
	}
	
	private void initializeControlMessage( InMessage inMessage ) {
		ControlMessage message = new ControlMessage();
		invokeController( message );
	}
	
	private void json_formed( OutMessage outMessage ) {
		// form json and send it to server
		server.sendResponse(/*json_response*/);
	}

	/*
	 * TODO: Need to separate into smaller subroutines
	 */
	private void invokeController( ControlMessage message ) {

		ResponseControlMessage response;
		// Figure out which controller to be called from json input.
		if( message instanceof UserControlMessage ) {
			response = currentUser.doAction( (UserControlMessage)message );
		} else if( message instanceof MoneyInfoControlMessage ) {
			response = moneyInfo.doAction( (MoneyInfoControlMessage)message );
		} else if( message instanceof MoneyPlanControlMessage ) {
			response = moneyPlan.doAction( (MoneyPlanControlMessage)message );
		} else {
			response = new ResponseControlMessage();
		}

		generateOutMessage( response );
	}
	
	private void generateOutMessage( ResponseControlMessage response ) {
		OutMessage outgoingMessage = new OutMessage();
		
		json_formed( outgoingMessage );
	}
}
