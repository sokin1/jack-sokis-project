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
	
	/*
	 * Maybe need it at some point
	 */
//	private Server server;

	public Acceptor() {
		currentUser = UserController.getInstance();
		moneyInfo = MoneyInfoController.getInstance();
		moneyPlan = MoneyPlanController.getInstance();
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
	public ControlMessage invokeController(/*json_request*/) {
		ControlMessage message = getMessage();
		// Figure out which controller to be called from json input.

		if( message instanceof UserControlMessage ) {
			return currentUser.doAction( message );
		} else if( message instanceof MoneyInfoControlMessage ) {
			return moneyInfo.doAction( message );
		} else if( message instanceof MoneyPlanControlMessage ) {
			return moneyPlan.doAction( message );
		} else {
			return message;
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
