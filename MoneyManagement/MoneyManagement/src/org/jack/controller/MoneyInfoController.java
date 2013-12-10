package org.jack.controller;

import org.jack.dto.moneyinfo.MoneyInfo;

public class MoneyInfoController extends ControllerBase {

	private static MoneyInfoController instance = null;
	
	MoneyInfo moneyInfo;
	
	public MoneyInfoController() {
		moneyInfo = new MoneyInfo();
	}
	
	public static MoneyInfoController getInstance() {
		if( instance == null ) {
			instance = new MoneyInfoController();
		}
		return instance;
	}
	
	public MoneyInfoController( MoneyInfo moneyInfo ) {
		this.moneyInfo = moneyInfo;
	}
	
	public void setMoneyInfo( MoneyInfo moneyInfo ) {
		this.moneyInfo = moneyInfo;
	}
	
	public MoneyInfo getMoneyInfo() {
		return moneyInfo;
	}
	
	public void modifyMoneyInfo() {
	}
	
	private boolean checkValidity() {
		return true;
	}
}
