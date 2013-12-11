package org.jack.server.dto.moneyflow;

import java.util.Date;

public class ExpenseDTO {

	public int type;	// Distinguish current expense and future expense
	public double amount;
	public String description;
	public long date;
	
	// For future and past expenses
	public ExpenseDTO( int type, double amount, String description, long date ) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.date = date;
	}
	
	// For current expenses
	public ExpenseDTO( int type, double amount, String description ) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.date = System.currentTimeMillis();
	}
	
	// For retrieving expenses
	public ExpenseDTO( int type, long date ) {
		this.type = type;
		this.date = date;
	}
}
