package org.jack.server.dto.moneyinfo;

public class MoneyInfoDTO {

	public int type;
	public double currentValue;

	// Update currentValue
	public MoneyInfoDTO( int type, double currentValue ) {
		this.type = type;
		this.currentValue = currentValue;
	}
	
	// Retrieve currentValue
	public MoneyInfoDTO( int type ) {
		this.type = type;
	}
}
