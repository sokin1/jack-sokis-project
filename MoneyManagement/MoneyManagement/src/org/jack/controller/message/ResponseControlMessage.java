package org.jack.controller.message;

public class ResponseControlMessage extends ControlMessage {
	
	private String statusDetail;

	private String action;
	
	private ControlMessage actionMessage;

	public ResponseControlMessage( int type ) {
		super( type );
	}
	
	private boolean validity() {
		return true;
	}
}
