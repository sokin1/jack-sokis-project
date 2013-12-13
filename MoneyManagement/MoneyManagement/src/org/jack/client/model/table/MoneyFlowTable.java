package org.jack.client.model.table;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class MoneyFlowTable extends JTable {

	JTable table;

	public MoneyFlowTable() {
		AbstractTableModel model = new MoneyFlowTableModel();
		table = new JTable( model );
	}
}
