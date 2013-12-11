package org.jack.client.model.table;

import javax.swing.table.AbstractTableModel;

public class MoneyFlowTableModel extends AbstractTableModel {
	private String[] columnNames = { "Date", "Amount", "Description" };
	private Object[][] data = { 
			{ "Kathy", new Integer(5), new Boolean(false) },
			{ "John", new Integer(3), new Boolean(true) },
		    { "Sue", new Integer(2), new Boolean(false) },
		    { "Jane", new Integer(20), new Boolean(true) },
		    { "Joe", new Integer(10), new Boolean(false) }
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
}
