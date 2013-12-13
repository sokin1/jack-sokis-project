package org.jack.server.dto;

/*
 * Outgoing Json Format
 * {
 * 		client 	 : [IP-address(maybe deleted)],
 * 		email  	 : [client's email],
 * 		response : {
 * 			result   : [succeed or fail],
 * 			category : [request category],
 * 			type	 : [request type],
 * 			detail 	 : [detailed description],
 * 			code     : [not defined]
 * 		}
 * }
 */
public class OutMessage {

	private String client;
	private String email;
	private ResponseMessage response;
	
	public OutMessage() {}
	
	public OutMessage( String client, String email, ResponseMessage response ) {
		this.client = client;
		this.email = email;
		this.response = response;
	}
	
	public String getClient() {
		return client;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ResponseMessage getResponseBody() {
		return response;
	}
}
