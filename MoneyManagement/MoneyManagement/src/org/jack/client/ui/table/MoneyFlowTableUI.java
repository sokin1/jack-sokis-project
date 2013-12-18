package org.jack.client.ui.table;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
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

	public static int ROWHEIGHT = 64;
	public static int HEADERHEIGHT = 32;
	public static int DATEWIDTH = 80;
	public static int DESCWIDTH = 540;
	public static int AMOUNTWIDTH = 140;
	public static int ICONWIDTH = 40;
	public static int FONTSIZEAMOUNT = 84;
	public static int FONTSIZEDESC = 24;
	public static int FONTSIZEDATE = 12;

	public static int COLNUM = 3;

	public static int ICONCOLUMN = 0;
	public static int DATECOLUMN = 1;
	public static int DESCCOLUMN = 2;
	public static int AMOUNTCOLUMN = 3;
	
	public static String DATE = "Date";
	public static String DESCRIPTION = "Description";
	public static String AMOUNT = "Amount";

	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;

	public MoneyFlowTableUI() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try{
			ge.registerFont( Font.createFont( Font.TRUETYPE_FONT, MoneyFlowTableUI.class.getResourceAsStream( "../../resource/font/Jive.ttf" ) ) );
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
		table.getColumnModel().getColumn(ICONCOLUMN).setPreferredWidth( ICONWIDTH );
		table.getColumnModel().getColumn(DATECOLUMN).setPreferredWidth( DATEWIDTH );
		table.getColumnModel().getColumn(DESCCOLUMN).setPreferredWidth( DESCWIDTH );
		table.getColumnModel().getColumn(AMOUNTCOLUMN).setPreferredWidth( AMOUNTWIDTH );

		table.getColumnModel().getColumn(ICONCOLUMN).setCellRenderer( new IconRenderer() );
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

		Font customFont;

		public TableHeaderRenderer() {
			setOpaque( true );
		}

		public Component getTableCellRendererComponent (
								JTable table, Object object,
								boolean isSelected, boolean hasFocus,
								int row, int column ) {
			try {
				customFont = Font.createFont( Font.TRUETYPE_FONT, MoneyFlowTableUI.class.getResourceAsStream( "../../resource/font/Jive.ttf" ) ).deriveFont( 24f );
			} catch( FontFormatException e ) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			setFont( customFont );
			setText( object.toString() );
			setBackground( Color.YELLOW );
			setHorizontalAlignment( SwingConstants.CENTER );
			setVerticalAlignment( SwingConstants.BOTTOM );
			return this;
		}
	}

	static class DateRenderer extends DefaultTableCellRenderer {

		DateFormat formatter;
		
		public DateRenderer() { super(); }
		
		public Component getTableCellRendererComponent (
				JTable table, Object object,
				boolean isSelected, boolean hasFocus,
				int row, int column ) {
			if( row % 2 != 0 ) {
				setBackground( Color.LIGHT_GRAY );
			} else {
				setBackground( Color.WHITE );
			}
			if( formatter == null ) {
				formatter = DateFormat.getDateInstance();
			}

			Date today = new Date( System.currentTimeMillis() );
			if( formatter.format( today ).equals( formatter.format( object ) ) ) {
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime( (Date)object );
			if( calendar.get( Calendar.DAY_OF_WEEK ) == Calendar.SUNDAY ) {
				setForeground( Color.BLUE );
			} else if( calendar.get( Calendar.DAY_OF_WEEK ) == Calendar.SATURDAY ) {
				setForeground( Color.RED );
			}

			setText( ( object == null ) ? "" : formatter.format( object ) );
			return this;
		}
	}

	static class IntegerRenderer extends DefaultTableCellRenderer {

		public IntegerRenderer() { super(); }

		public Component getTableCellRendererComponent (
				JTable table, Object object,
				boolean isSelected, boolean hasFocus,
				int row, int column ) {
			if( row % 2 != 0 ) {
				setBackground( Color.LIGHT_GRAY );
			} else {
				setBackground( Color.WHITE );
			}

			if( (Integer)object < 0 ) {
				setForeground( Color.RED );
				setText( object.toString() );
			} else {
				setForeground( Color.GREEN );
				setText( object.toString() );
			}

			setFont( new Font( "Microsoft JhenHei", Font.BOLD, 84 ) );
			return this;
		}
	}

	static class StringRenderer extends DefaultTableCellRenderer {

		public StringRenderer() { super(); }

		public Component getTableCellRendererComponent (
				JTable table, Object object,
				boolean isSelected, boolean hasFocus,
				int row, int column ) {
			if( row % 2 != 0 ) {
				setBackground( Color.LIGHT_GRAY );
			} else {
				setBackground( Color.WHITE );
			}

			setText( object.toString() );
			return this;
		}
	}

	static class IconRenderer extends DefaultTableCellRenderer {

		private ImageIcon newIcon = null;
		DateFormat formatter;

		public IconRenderer() { super(); }

		public Component getTableCellRendererComponent(
				JTable table, Object object,
				boolean isSelected, boolean hasFocus,
				int row, int column ) {
			if( formatter == null ) {
				formatter = DateFormat.getDateInstance();
			}

			Date today = new Date( System.currentTimeMillis() );
			Object currentDate = table.getModel().getValueAt( row, DATECOLUMN );
			if( formatter.format( today ).equals( formatter.format( currentDate ) ) ) {
				try {
					// TODO : use relative path not absolute path
					newIcon = new ImageIcon( ImageIO.read( new File( "C:\\Users\\jkim\\Documents\\GitHub\\jack-sokis-project\\MoneyManagement\\MoneyManagement\\src\\org\\jack\\client\\resource\\image\\new.gif" ) ) );
				} catch( IOException e ) {
					e.printStackTrace();
				}
			}
			setBorder( BorderFactory.createEmptyBorder() );
			setIcon( newIcon );
			return this;
		}
	}
}
