package org.jack.client.ui.table;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
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

	private static int ROWHEIGHT = 64;
	private static int HEADERHEIGHT = 32;
	private static int DATEWIDTH = 80;
	private static int DESCWIDTH = 560;
	private static int AMOUNTWIDTH = 160;
	private static int FONTSIZEAMOUNT = 84;
	private static int FONTSIZEDESC = 24;
	private static int FONTSIZEDATE = 12;

	private static int COLNUM = 3;

	private static int DATECOLUMN = 0;
	private static int DESCCOLUMN = 1;
	private static int AMOUNTCOLUMN = 2;

	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private static Font customFont = null;

	public MoneyFlowTableUI() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try{
			customFont = Font.createFont( Font.TRUETYPE_FONT, MoneyFlowTableUI.class.getResourceAsStream( "../../resource/font/bistro.ttf" ) ).deriveFont( 24 );
			ge.registerFont( Font.createFont( Font.TRUETYPE_FONT, MoneyFlowTableUI.class.getResourceAsStream( "../../resource/font/bistro.ttf" ) ) );
		} catch( IOException e ) {
			e.printStackTrace();
		} catch( FontFormatException e ) {
			e.printStackTrace();
		}

		initializeUI();
	}

	public void initializeUI() {
		setTitle( "Simple Table Application" );
		setSize( 800, 600 );
		setBackground( Color.gray );

		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		table = new JTable( new MoneyFlowTableModel() );

		initTableHeader();
		initTableCells();

		table.getModel().addTableModelListener( this );

		scrollPane = new JScrollPane( table );
		topPanel.add( scrollPane, BorderLayout.CENTER );
	}

	public void initTableHeader() {
		table.getTableHeader().setDefaultRenderer( new TableHeaderRenderer() );
		table.getTableHeader().setPreferredSize( new Dimension( 800, HEADERHEIGHT ) );
	}

	public void initTableCells() {
		table.getColumnModel().getColumn(DATECOLUMN).setPreferredWidth( DATEWIDTH );
		table.getColumnModel().getColumn(DESCCOLUMN).setPreferredWidth( DESCWIDTH );
		table.getColumnModel().getColumn(AMOUNTCOLUMN).setPreferredWidth( AMOUNTWIDTH );

		table.getColumnModel().getColumn(DATECOLUMN).setCellRenderer( new DateRenderer() );
		table.getColumnModel().getColumn(DESCCOLUMN).setCellRenderer( new StringRenderer() );
		table.getColumnModel().getColumn(AMOUNTCOLUMN).setCellRenderer( new IntegerRenderer() );

		table.setRowHeight( ROWHEIGHT );
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

	public class TableHeaderRenderer extends JLabel implements TableCellRenderer {

		public TableHeaderRenderer() {
			setOpaque( true );
		}

		public Component getTableCellRendererComponent (
								JTable table, Object object,
								boolean isSelected, boolean hasFocus,
								int row, int column ) {
			setText( object.toString() );
			setBackground( Color.YELLOW );
			setHorizontalAlignment( SwingConstants.CENTER );
			setFont( new Font( "Microsoft JhenHei", Font.BOLD, 24 ) );
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

			Date today = new Date( System.currentTimeMillis() );
			if( formatter.format( today ).equals( formatter.format( value ) ) ) {
				setForeground( Color.CYAN );
			} else {
				setForeground( Color.WHITE );
			}

			setText( ( value == null ) ? "" : formatter.format( value ) );
		}
	}

	static class IntegerRenderer extends DefaultTableCellRenderer {

		public IntegerRenderer() { super(); }

		public void setValue( Object value ) {
			if( (Integer)value < 0 ) {
				setForeground( Color.RED );
				setText( value.toString() );
			} else {
				setForeground( Color.GREEN );
				setText( value.toString() );
			}
			setFont( new Font( "Microsoft JhenHei", Font.BOLD, 84 ) );
		}
	}

	static class StringRenderer extends DefaultTableCellRenderer {

		public StringRenderer() { super(); }

		public void setValue( Object value ) {
			setFont( customFont );
			setText( value.toString() );
		}
	}
}
