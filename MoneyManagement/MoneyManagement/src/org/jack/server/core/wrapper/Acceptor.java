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
		invokeController();
	}
	
	public void json_formed( ResponseControlMessage response ) {
		// form json and send it to server
	}

	/*
	 * TODO: Need to separate into smaller subroutines
	 */
	private void invokeController(/*json_request*/) {
		ControlMessage message = getMessage();
		// Figure out which controller to be called from json input.

		if( message instanceof UserControlMessage ) {
			currentUser.doAction( message );
		} else if( message instanceof MoneyInfoControlMessage ) {
			moneyInfo.doAction( message );
		} else if( message instanceof MoneyPlanControlMessage ) {
			moneyPlan.doAction( message );
		}
	}

	/*
	 * json_request is unfolded here
	 * and forms ControlMessage to be sent to controller objects
	 */
	public ControlMessage getMessage(/*json_request*/) {
		String type = "USER";

		if( type == "USER") {
			return new UserControlMessage( 10, "Jack", "sokin1@Hotmail.com", "wornr123" );
		} else if( type == "MONEYINFO") {
			return new MoneyInfoControlMessage();
		} else if( type == "MONEYPLAN" ) {
			return new MoneyPlanControlMessage();
		} else {
			return new ResponseControlMessage();
		}
	}
}
