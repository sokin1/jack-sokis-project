package org.jack.server.core.data.user;

import org.jack.server.core.data.moneyinfo.MoneyInfo;
import org.jack.server.core.data.moneyinfo.MoneyPlan;
import org.jack.server.core.data.moneyinfo.*;

public class User {

	private String name;
	private String userID;
	private String password;
	private MoneyInfo moneyInfo;
	private MoneyPlan moneyPlan;
	
	public User() {
		name = "";
		userID = "";
		password = "";
		moneyInfo = new MoneyInfo();
		moneyPlan = new MoneyPlan();
	}
	
	public User( String name, String userID, String password, MoneyInfo moneyInfo, MoneyPlan moneyPlan ) {
		this.name = name;
		this.userID = userID;
		this.password = password;
		this.moneyInfo = moneyInfo;
		this.moneyPlan = moneyPlan;
	}
	
	public void setPassword( String oldPassword, String password ) {
		if( oldPassword == this.password ) {
			this.password = password;
		} else {
			System.out.println( "old password is incorrect" );
		}
	}
	
	private String getPassword() {
		return password;
	}
}
