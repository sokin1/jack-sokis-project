package org.jack.core;

public class Acceptor {

	private static Acceptor instance = null;

	public Acceptor() {
	}

	public static Acceptor getInstance() {
		if( instance == null ) {
			instance = new Acceptor();
		}
		return instance;
	}

	
}
