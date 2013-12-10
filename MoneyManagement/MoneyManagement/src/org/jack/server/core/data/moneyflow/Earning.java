package org.jack.server.core.data.moneyflow;

import java.util.Date;

public class Earning extends MoneyFlow {

	boolean valid;

	public Earning() {
		super();
		valid = false;
	}
	
	public Earning( int id, String type, Date date, String description, double amount ) {
		super( id, type, date, description, amount );

		if( !checkValidInput( date, amount ) ) {
			valid = false;
		} else {
			valid = true;
		}
	}

	public boolean checkValidInput( Date date, double amount ) {

		long millisecond = date.getTime();

		if( System.currentTimeMillis() < millisecond || amount < 0.0 ) {
			return false;
		}

		return true;
	}
}
