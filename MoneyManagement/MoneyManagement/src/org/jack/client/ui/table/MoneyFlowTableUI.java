package org.jack.client.ui.table;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import org.jack.client.model.table.MoneyFlowTableModel;

public class MoneyFlowTableUI extends JFrame implements TableModelListener {

	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;

	public MoneyFlowTableUI() {
		setTitle( "Simple Table Application" );
		setSize( 300, 200 );
		setBackground( Color.gray );

		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		table = new JTable( new MoneyFlowTableModel() );

		table.getModel().addTableModelListener( this );

		TableColumn column = null;
		column = table.getColumnModel().getColumn( 0 );
		column.setPreferredWidth( 80 );
		column = table.getColumnModel().getColumn( 1 );
		column.setPreferredWidth( 50 );
		column = table.getColumnModel().getColumn( 2 );
		column.setPreferredWidth( 200 );

		scrollPane = new JScrollPane( table );
		topPanel.add( scrollPane, BorderLayout.CENTER );
	}

	public void tableChanged( TableModelEvent e ) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel)e.getSource();
		String columnName = model.getColumnName( column );
		Object data = model.getValueAt( row,  column );

		System.out.println( data.toString() );
	}

	public static void main( String args[] ) {
		MoneyFlowTableUI launcher = new MoneyFlowTableUI();
		launcher.setVisible( true );
	}
	
	
}
