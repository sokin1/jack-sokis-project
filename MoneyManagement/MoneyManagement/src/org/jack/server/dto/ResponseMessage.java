package org.jack.server.dto;

public class ResponseMessage {

	private int result;
	private int category;
	private int type;
	private String detail;
	private int code;
	
	public ResponseMessage() {}
	
	public ResponseMessage( int result, int category, int type, String detail, int code ) {
		this.result = result;
		this.category = category;
		this.type = type;
		this.detail = detail;
		this.code = code;
	}
	
	public int getResult() {
		return result;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getType() {
		return type;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public int getCode() {
		return code;
	}
}
