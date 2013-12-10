package org.jack.controller;

import org.jack.dto.moneyinfo.MoneyPlan;

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
