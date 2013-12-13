package org.jack.server.controller;

import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.MoneyPlanControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;
import org.jack.server.core.data.moneyinfo.MoneyPlan;

public class MoneyPlanController extends ControllerBase {

	private static MoneyPlanController instance = null;
	
	MoneyPlan moneyPlan;
	
	public MoneyPlanController() {
		moneyPlan = new MoneyPlan();
	}
	
	public static MoneyPlanController getInstance() {
		if( instance == null ) {
			instance = new MoneyPlanController();
		}
		return instance;
	}
	
	public MoneyPlanController( MoneyPlan moneyPlan ) {
		this.moneyPlan = moneyPlan;
	}
	
	public ResponseControlMessage doAction( ControlMessage message ) {
		return new ResponseControlMessage();
	}
	public void setMoneyPlan( MoneyPlan moneyPlan ) {
		this.moneyPlan = moneyPlan;
	}
	
	public MoneyPlan getMoneyPlan() {
		return moneyPlan;
	}
	
	public void modifyMoneyPlan() {
	}
	
	private boolean checkValidity() {
		return true;
	}
}
