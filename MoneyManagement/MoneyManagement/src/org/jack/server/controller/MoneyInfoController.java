package org.jack.server.controller;

import org.jack.server.controller.message.ControlMessage;
import org.jack.server.controller.message.MoneyInfoControlMessage;
import org.jack.server.controller.message.ResponseControlMessage;
import org.jack.server.core.data.moneyinfo.MoneyInfo;

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
	
	public ControlMessage doAction( ControlMessage message ) {
		return new ResponseControlMessage();
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
