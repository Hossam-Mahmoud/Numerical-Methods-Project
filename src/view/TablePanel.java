package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.STATIC_LENGTH;

@SuppressWarnings("serial")
public class TablePanel extends JPanel {

	JTable jtable;
	String[] fields;
	String[][] data;
	JScrollPane pane;

	@SuppressWarnings("deprecation")
	public TablePanel(String[][] data, String[] fields) {
		super();
		setLayout(null);

		this.fields = fields;
		this.data = data;

		setBounds(STATIC_LENGTH.TABLE_X, STATIC_LENGTH.TABLE_Y,
				STATIC_LENGTH.TABLE_WIDTH + 10, STATIC_LENGTH.TABLE_HEIGHT);

		// adding JTable

		jtable = new JTable(this.data, fields);
		pane = new JScrollPane(jtable);
		pane.setBounds(STATIC_LENGTH.TABLE_X, STATIC_LENGTH.TABLE_Y - 100,
				STATIC_LENGTH.TABLE_WIDTH, STATIC_LENGTH.TABLE_HEIGHT - 200);

		add(pane);

		setFocusable(true);
		requestDefaultFocus();
		requestFocus();

	}

	public void setData(double[][] answer, int length) {
		if (length == 1) {
			for (int i = 1; i < STATIC_LENGTH.MAX_ITERATION; i++)
				for (int j = 0; j < fields.length; j++)
					jtable.setValueAt("", i, j);
		}
		for (int i = 0; i < length; i++)
			for (int j = 0; j < fields.length; j++)
				jtable.setValueAt(answer[i][j] + "", i, j);

		setFocusable(true);
		requestFocus();
		requestDefaultFocus();
		repaint();
		pane = new JScrollPane(jtable);
		pane.setBounds(STATIC_LENGTH.TABLE_X, STATIC_LENGTH.TABLE_Y - 100,
				STATIC_LENGTH.TABLE_WIDTH, STATIC_LENGTH.TABLE_HEIGHT - 200);

		add(pane);

	}

}
