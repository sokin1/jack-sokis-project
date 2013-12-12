package org.jack.client.ui.main;

import org.jack.client.model.main.MManagementModel;
import org.jack.client.ui.table.MoneyFlowTableUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class MManagementMainUI extends JFrame {

	private MManagementUI ui;
	private MManagementModel model;
	
	private JPanel mainPanel;
	private JTable mainTable;

	public static void main( String args[] ) {
		MManagementMainUI mainUI = new MManagementMainUI();
		
	}
	
	public MManagementMainUI() {
		initializeUI();
	}
	
	private void initializeUI() {
		// Draw main page of application
		setTitle( "Money Management" );
		setSize( 300, 200 );
		setBackground( Color.GRAY );

		mainPanel = new JPanel();
		mainPanel.setLayout( new BorderLayout() );
		getContentPane().add( mainPanel );
	}
	
	private void initialize() {
		// initialize ui and model
	}
}