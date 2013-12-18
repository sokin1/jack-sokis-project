package org.jack.client.model.table;

import java.util.Date;

import javax.swing.table.AbstractTableModel;

import org.jack.client.ui.table.MoneyFlowTableUI;

public class MoneyFlowTableModel extends AbstractTableModel {

	private String[] columnNames = { "", MoneyFlowTableUI.DATE, MoneyFlowTableUI.DESCRIPTION, MoneyFlowTableUI.AMOUNT };
	private Object[][] data = {
			{ new Object(), new Date( System.currentTimeMillis() ), new String( "earn" ), new Integer( 5 ) },
			{ new Object(), new Date( System.currentTimeMillis() ), new String( "earn" ), new Integer( 3 ) },
		    { new Object(), new Date( System.currentTimeMillis() ), new String( "expense" ), new Integer( -2 ) },
		    { new Object(), new Date( System.currentTimeMillis() ), new String( "earn" ), new Integer( 20 ) },
		    { new Object(), new Date( System.currentTimeMillis() ), new String( "expense" ), new Integer( -10 ) }
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
		if( col == MoneyFlowTableUI.AMOUNTCOLUMN ) {
			String strValue = (String)value;
			int intValue = Integer.parseInt( strValue );
			data[row][col] = intValue;
		} else if ( col == MoneyFlowTableUI.DESCCOLUMN ) {
			data[row][col] = value;
		} else {
			// TODO : handle the case for Date
			data[row][col] = value;
		}

		fireTableCellUpdated( row, col );
	}
	
	public String getColumnName( int index ) {
		return columnNames[index];
	}
}
