package org.jack.server.core.data.moneyinfo;

import java.util.ArrayList;
import java.util.List;

import org.jack.server.core.data.moneyflow.Earning;
import org.jack.server.core.data.moneyflow.Expense;
import org.jack.server.core.data.moneyflow.MoneyFlow;
import org.jack.server.core.data.moneyflow.*;

public class MoneyInfo {

	private double currentValue;

	private List<Expense> expenses;

	private List<Earning> earnings;

	public MoneyInfo() {
		currentValue = 0.0;

		expenses = new ArrayList<Expense>();
		earnings = new ArrayList<Earning>();
	}

	public MoneyInfo( double currentValue ) {
		this.currentValue = currentValue;

		expenses = new ArrayList<Expense>();
		earnings = new ArrayList<Earning>();
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue( double currentValue ) {
		this.currentValue = currentValue;
	}

	public void addExpense( Expense expense ) {
		if( validate( expense) ) {
			expenses.add( expense );
		} else {
			System.out.println( "Invalid expense" );
		}
	}
	
	public void removeExpense( int index ) {
	}

	public void addEarning( Earning earning ) {
		if( validate( earning ) ) {
			earnings.add( earning );
		} else {
			System.out.println( "Invalid earning" );
		}
	}
	
	public void removeEarning( int index ) {
		
	}

	private boolean validate( MoneyFlow newEntry ) {
		return true;
	}
}
