package org.jack.server.dto.moneyinfo;

public class MoneyPlanDTO {

	public int type;
	public double goal;
	
	// Update goal
	public MoneyPlanDTO( int type, int goal ) {
		this.type = type;
		this.goal = goal;
	}
	
	// Retrieve goal
	public MoneyPlanDTO( int type ) {
		this.type = type;
	}
}
