package org.jack.server.core.data.moneyflow;

import java.util.Date;

public class MoneyFlow {

	protected int id;

	protected String type;
	protected Date date;
	protected String description;
	protected double amount;
	
	public MoneyFlow() {
		id = -1;
		type = "";
		date = new Date();
		description = "";
		amount = 0.0;
	}

	public MoneyFlow(int id, String type, Date date, String description, double amount ) {
		this.id = id;
		this.type = type;
		this.date = date;
		this.description = description;
		this.amount = amount;
	}	

	public void clear() {
	};

	public void setType( String type ) {
		this.type = type;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public void setAmount( double amount ) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
}
