package org.jack.db;

import java.sql.*;

import org.jack.controller.message.ControlMessage;

public class DatabaseInterface {

	private static DatabaseInterface instance = null;
	
	private Connection connection = null;
	
	private Statement statement = null;

	/*
	 * For standalone purpose
	 */
//	public static void main( String[] args ) {
//		DatabaseInterface instance = DatabaseInterface.getInstance();
//		instance.setQuery();
//		
//		System.out.println( "Records created successfully" );
//	}

	public static DatabaseInterface getInstance() {
		if( instance == null ) {
			instance = new DatabaseInterface();
		}
		return instance;
	}

	public DatabaseInterface() {
		try {
			Class.forName( "org.sqlite.JDBC" );
			connection = DriverManager.getConnection( "jdbc:sqlite:src/org/jack/db/user.db" );
			connection.setAutoCommit( false );

			System.out.println( "Opened database successfully" );
		} catch( Exception e ) {
			System.err.println( e.getClass().getName() + " : " + e.getMessage() );
			System.exit( 0 );
		}
	}

	private boolean checkValidity() {
		return true;
	}

	public void getRequest( ControlMessage message ) {
		if( checkValidity() ) {
			int jobType = message.getType() / 10;
			switch( jobType ) {
			case 1:
				handleUserRequest( message );
				break;
			}
		}
	}

	public void handleUserRequest( ControlMessage message ) {
		int specificJobType = message.getType() % 10;
		switch( specificJobType ) {
		case 0:
			runQuery( message.getMessageForDB() );
			break;
		}
	}

	private void runQuery( String query ) {
		try {
			statement = connection.createStatement();

			statement.executeUpdate( query );

			statement.close();
			connection.commit();
			connection.close();
		} catch( Exception e ) {
			System.err.println( e.getClass().getName() + "[runQuery] : " + e.getMessage() );
			System.exit( 0 );
		}
	}
}