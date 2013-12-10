package org.jack.server.controller.message;

public class ControlMessage {

	public static final int CREATE_USER = 10;
	public static final int LOGIN_USER = 11;
	public static final int LOGOUT_USER = 12;
	public static final int RETRIEVE_USER = 13;
	public static final int UPDATE_USER = 14;
	public static final int REMOVE_USER = 15;

	public static final int CREATE_MONEY = 20;
	public static final int UPDATE_MONEY = 21;
	public static final int REMOVE_MONEY = 22;

	public static final int CREATE_PLAN = 30;
	public static final int UPDATE_PLAN = 31;
	public static final int REMOVE_PLAN = 32;

	public static final int CREATE_USER_SUCCEED = 101;
	public static final int CREATE_USER_FAIL = 100;
	public static final int LOGIN_USER_SUCCEED  = 111;
	public static final int LOGIN_USER_FAIL = 110;
	public static final int LOGOUT_USER_SUCCEED = 121;
	public static final int LOGOUT_USER_FAIL = 120;
	public static final int RETRIEVE_USER_SUCCEED = 131;
	public static final int RETRIEVE_USER_FAIL = 130;
	public static final int UPDATE_USER_SUCCEED = 141;
	public static final int UPDATE_USER_FAIL = 140;
	public static final int REMOVE_USER_SUCCEED = 151;
	public static final int REMOVE_USER_FAIL = 150;

	public static final int CREATE_MONEY_SUCCEED = 201;
	public static final int CREATE_MONEY_FAIL = 200;
	public static final int UPDATE_MONEY_SUCCEED = 211;
	public static final int UPDATE_MONEY_FAIL = 210;
	public static final int REMOVE_MONEY_SUCCEED = 221;
	public static final int REMOVE_MONEY_FAIL = 220;

	public static final int CREATE_PLAN_SUCCEED = 301;
	public static final int CREATE_PLAN_FAIL = 300;
	public static final int UPDATE_PLAN_SUCCEED = 311;
	public static final int UPDATE_PLAN_FAIL = 310;
	public static final int REMOVE_PLAN_SUCCEED = 321;
	public static final int REMOVE_PLAN_FAIL = 320;

	protected int type;
	
	public ControlMessage() {
	}

	public ControlMessage( int type ) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
	public String getMessageForDB() {
		return "";
	}
}
