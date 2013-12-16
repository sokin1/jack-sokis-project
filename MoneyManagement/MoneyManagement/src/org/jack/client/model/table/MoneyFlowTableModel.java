package org.jack.client.model.table;

import java.util.Date;

import javax.swing.table.AbstractTableModel;

public class MoneyFlowTableModel extends AbstractTableModel {

	private String[] columnNames = { "Date", "Description", "Amount" };
	private Object[][] data = {
			{ new Date( System.currentTimeMillis() ), new String( "earn" ), new Integer( 5 ) },
			{ new Date( System.currentTimeMillis() ), new String( "earn" ), new Integer( 3 ) },
		    { new Date( System.currentTimeMillis() ), new String( "expense" ), new Integer( -2 ) },
		    { new Date( System.currentTimeMillis() ), new String( "earn" ), new Integer( 20 ) },
		    { new Date( System.currentTimeMillis() ), new String( "expense" ), new Integer( -10 ) }
	};

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public Object getValueAt( int row, int col ) {
		return data[row][col];
	}

	public Class GetColumnClass( int c ) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable( int row, int col ) {
		return true;
	}

	public void setValueAt( Object value, int row, int col ) {
		data[row][col] = value;
		fireTableCellUpdated( row, col );
	}
	
	public String getColumnName( int index ) {
		return columnNames[index];
	}
}
