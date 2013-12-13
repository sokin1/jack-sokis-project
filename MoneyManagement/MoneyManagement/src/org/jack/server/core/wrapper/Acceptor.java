package org.jack.server.core.wrapper;

import org.jack.server.controller.MoneyInfoController;
import org.jack.server.controller.MoneyPlanController;
import org.jack.server.controller.UserController;
import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.MoneyInfoControlMessage;
import org.jack.server.controller.message.MoneyPlanControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;
import org.jack.server.controller.message.UserControlMessage;

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
		
		ControlMessage message = new ControlMessage();
		invokeController( message );
	}
	
	public void json_formed( ResponseControlMessage response ) {
		// form json and send it to server
		server.sendResponse();
	}

	/*
	 * TODO: Need to separate into smaller subroutines
	 */
	private void invokeController( ControlMessage message ) {

		ResponseControlMessage response;
		// Figure out which controller to be called from json input.
		if( /*message instanceof UserControlMessage*/ ) {
			response = currentUser.doAction( (UserControlMessage)message );
		} else if( /*message instanceof MoneyInfoControlMessage*/ ) {
			response = moneyInfo.doAction( (MoneyInfoControlMessage)message );
		} else if( /*message instanceof MoneyPlanControlMessage*/ ) {
			response = moneyPlan.doAction( (MoneyPlanControlMessage)message );
		}

		json_formed( response );
	}
}
