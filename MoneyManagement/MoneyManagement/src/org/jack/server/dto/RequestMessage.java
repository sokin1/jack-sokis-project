package org.jack.server.dto;

public class RequestMessage {
	private int category;
	private int type;
	private RequestData data;
	
	public RequestMessage() {}
	
	public RequestMessage( int category, int type, RequestData data ) {
		this.category = category;
		this.type = type;
		this.data = data;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getType() {
		return type;
	}
	
	public RequestData getData() {
		return data;
	}
}
