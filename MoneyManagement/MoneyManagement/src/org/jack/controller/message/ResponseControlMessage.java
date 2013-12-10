package org.jack.controller.message;

public class ResponseControlMessage extends ControlMessage {

	private String statusDetail;

	private String action;

	private ControlMessage actionMessage;

	public ResponseControlMessage( int type, String statusDetail, String action ) {
		super( type );
		this.action = action;
		this.statusDetail = statusDetail;
	}

	public ResponseControlMessage( int type, String statusDetail, String action, ControlMessage actionMessage ) {
		super( type );
		this.action = action;
		this.statusDetail = statusDetail;
		this.actionMessage = actionMessage;
	}

	private boolean validity() {
		return true;
	}
}
