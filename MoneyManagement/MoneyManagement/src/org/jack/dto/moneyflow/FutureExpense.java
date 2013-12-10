package org.jack.dto.moneyflow;

import java.util.Date;

public class FutureExpense extends MoneyFlow {

	private boolean expensed;

	public FutureExpense() {
		super();

		expensed = false;
	}

	public FutureExpense( int id, String type, Date date, String description, double amount ) {
		super( id, type, date, description, amount );

		if( checkValidInput( date, amount ) ) {
			expensed = false;
		} else {
			expensed = false;
			this.amount = 0.0;
		}
	}
	
	public boolean checkValidInput( Date date, double amount ) {

		long millisecond = date.getTime();

		if( System.currentTimeMillis() > millisecond || amount < 0.0 ) {
			return false;
		}

		return true;
	}
}
