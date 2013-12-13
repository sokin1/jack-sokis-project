package org.jack.server.dto;

/*
 * Incoming json Format
 * 	{
 * 		client   : [client's ip-address],
 * 		level    : [client's security level],
 * 		email  	 : [client's email(empty if not signing up)],
 * 		password : [client's password(empty if not signing up or already logged in)],
 * 		request  : {
 * 			category	: [request category(user, moneyinfo, moneyplan)],
 * 			type 		: [request type(signup, login, or logout],
 * 			data		: {...}
 * 		}
 *  }
 */

public class InMessage {

	private String client;
	private int level;
	private String email;
	private String password;
	private RequestMessage request;
	
	public InMessage() {}
	
	public InMessage( String client, int level, String email, String password, RequestMessage request ) {
		this.client = client;
		this.level = level;
		this.email = email;
		this.password = password;
		this.request = request;
	}
	
	public String getClient() {
		return client;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public RequestMessage getRequestBody() {
		return request;
	}
}
