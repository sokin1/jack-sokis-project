package org.jack.server.core.data.moneyinfo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jack.server.core.data.moneyflow.FutureEarning;
import org.jack.server.core.data.moneyflow.FutureExpense;
import org.jack.server.core.data.moneyflow.MoneyFlow;
import org.jack.server.dto.moneyflow.*;

public class MoneyPlan {

	private double goal;
	private MoneyInfo moneyInfo;
	private List<FutureExpense> futureExpenses;
	private List<FutureEarning> futureEarnings;
	
	private Date expectedDate;
	
	public MoneyPlan() {
		goal = 0.0;
		MoneyInfo moneyInfo = new MoneyInfo();
		futureExpenses = new ArrayList<FutureExpense>();
		futureEarnings = new ArrayList<FutureEarning>();
		expectedDate = new Date();
	}
	
	public MoneyPlan( double goal, MoneyInfo moneyInfo, Date expectedDate ) {
		this.goal = goal;
		this.moneyInfo = moneyInfo;
		this.expectedDate = expectedDate;
		
		futureExpenses = new ArrayList<FutureExpense>();
		futureEarnings = new ArrayList<FutureEarning>();
	}
	
	public void setNewGoal( double goal ) {
		this.goal = goal;
	}
	
	public double getNewGoal() {
		return goal;
	}
	
	public void setNewExpectedDate( Date expectedDate ) {
		this.expectedDate = expectedDate;
	}
	
	public Date getNewExpectedDate() {
		return expectedDate;
	}
	
	public void addNewFutureExpense( FutureExpense futureExpense ) {
		if( validate( futureExpense ) ) {
			futureExpenses.add( futureExpense );
		} else {
			System.out.println( "Invalid future expense" );
		}
	}
	
	public FutureExpense getFutureExpense( int id ) {
		if( id < futureExpenses.size() ) {
			return futureExpenses.get( id );
		} else {
			System.out.println( "Invalid index" );
			return new FutureExpense();
		}
	}
	
	public void addNewFutureEarning( FutureEarning futureEarning ) {
		if( validate( futureEarning ) ) {
			futureEarnings.add( futureEarning );
		} else {
			System.out.println( "Invalid future earning" );
		}
	}
	
	public FutureEarning getFutureEarning( int id ) {
		if( id < futureEarnings.size() ) {
			return futureEarnings.get( id );
		} else {
			System.out.println( "Invalid index" );
			return new FutureEarning();
		}
	}
	
	private boolean validate( MoneyFlow newEntry ) {
		return true;
	}
}
