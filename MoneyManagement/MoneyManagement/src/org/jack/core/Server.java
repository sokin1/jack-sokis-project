package org.jack.core;


import org.jack.controller.MoneyInfoController;
import org.jack.controller.MoneyPlanController;
import org.jack.controller.UserController;
import org.jack.db.DBFacade;

public class Server {

	private UserController currentUser;

	private MoneyInfoController moneyInfo;

	private MoneyPlanController moneyPlan;

	private Acceptor acceptor;

	public void initialize() {
		currentUser = UserController.getInstance();
		moneyInfo = MoneyInfoController.getInstance();
		moneyPlan = MoneyPlanController.getInstance();
		
		acceptor = Acceptor.getInstance();
	}
	
	public Server() {
		// Open handshaking port
		initialize();
	}
}
