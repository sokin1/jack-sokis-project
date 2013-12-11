package org.jack.server.dto.moneyflow;

public class EarningDTO {

	public int type;
	public double amount;
	public String description;
	public long date;
	
	// For future and past earning
	public EarningDTO( int type, double amount, String description, long date ) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.date = date;
	}
	
	// For current earning
	public EarningDTO( int type, double amount, String description ) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.date = System.currentTimeMillis();
	}
	
	// For Retreving earnings
	public EarningDTO( int type, long date ) {
		this.type = type;
		this.date = date;
	}
}
