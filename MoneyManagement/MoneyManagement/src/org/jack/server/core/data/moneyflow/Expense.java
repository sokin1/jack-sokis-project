package org.jack.server.core.data.moneyflow;

import java.util.Date;

public class Expense extends MoneyFlow {
	
	boolean valid;

	public Expense() {
		super();
		valid = false;
	}
	
	public Expense( int id, String type, Date date, String description, double amount ) {
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
