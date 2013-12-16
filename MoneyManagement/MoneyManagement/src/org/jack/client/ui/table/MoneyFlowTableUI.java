package org.jack.client.ui.table;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.DateFormat;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;

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

		TableColumn column = null;
		column = table.getColumnModel().getColumn( 0 );
		column.setPreferredWidth( 80 );
		column = table.getColumnModel().getColumn( 1 );
		column.setPreferredWidth( 200 );
		column = table.getColumnModel().getColumn( 2 );
		column.setPreferredWidth( 50 );

		table.setDefaultRenderer( Date.class, new DateRenderer() );
		table.setDefaultRenderer( Integer.class, new IntegerRenderer() );
		table.getModel().addTableModelListener( this);

//		table.getTableHeader().setDefaultRenderer( new TableHeaderRenderer() );
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
		launcher.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public class TableBodyRenderer extends JLabel implements TableCellRenderer {

		public TableBodyRenderer() {
		}

		public Component getTableCellRendererComponent (
								JTable table, Object object,
								boolean isSelected, boolean hasFocus,
								int row, int column ) {
			setBackground( Color.blue );
			return this;
		}
	}

	public class TableHeaderRenderer extends JLabel implements TableCellRenderer {

		public TableHeaderRenderer() {
			setOpaque( true );
		}

		public Component getTableCellRendererComponent (
								JTable table, Object object,
								boolean isSelected, boolean hasFocus,
								int row, int column ) {
			setText( (String)table.getValueAt( 0, column ) );
			setBackground( Color.YELLOW );
			return this;
		}
	}
	
	static class DateRenderer extends DefaultTableCellRenderer {
		DateFormat formatter;
		public DateRenderer() { super(); }
		
		public void setValue( Object value ) {
			if( formatter == null ) {
				formatter = DateFormat.getDateInstance();
			}
			setText( ( value == null ) ? "" : formatter.format( value ) );
		}
	}
	
	static class IntegerRenderer extends DefaultTableCellRenderer {

		public IntegerRenderer() { super(); }

		public void setValue( Object value ) {
			if( (Integer)value < 0 ) {
				setText( "-" + value );
				setBackground( Color.RED );
			} else {
				setText( (String)value );
			}
		}
	}
}
