package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import model.STATIC_LENGTH;
import controller.NewtonRaphsonAccController;

@SuppressWarnings("serial")
public class NewtonRaphsonAcceleratedPanel extends JPanel {
	JButton start, next, runAll;
	TablePanel tablePanel;
	DrawPanel drawPanel;
	NewtonRaphsonAccController controller;
	JLabel alabel, blabel;
	JTextField a, b;
	Model model;

	@SuppressWarnings("deprecation")
	public NewtonRaphsonAcceleratedPanel(NewtonRaphsonAccController controller) {
		super();
		setLayout(null);

		this.controller = controller;

		setBounds(STATIC_LENGTH.OUTPUT_X, STATIC_LENGTH.OUTPUT_Y,
				STATIC_LENGTH.OUTPUT_WIDTH, STATIC_LENGTH.OUTPUT_HEIGHT);

		// bisection panel buttons
		start = new JButton("Start");
		next = new JButton("Next");
		runAll = new JButton("run All");

		int bound = 85;

		int shift = this.getWidth() / 8;// width

		// add start , next buttons
		start.setBounds(STATIC_LENGTH.OUTPUT_X, STATIC_LENGTH.OUTPUT_Y, shift,
				25);
		next.setBounds(this.getX() + shift, this.getY(), shift, 25);
		runAll.setBounds(this.getX() + 2 * shift, this.getY(), shift, 25);

		add(start);
		add(next);
		add(runAll);
		
		// add Action Lisenteners
		NewtonRaphsonAccActions action = new NewtonRaphsonAccActions();
		start.addActionListener(action);
		next.addActionListener(action);
		runAll.addActionListener(action);

		// ADD input for bisection problem
		alabel = new JLabel("p : ");
		a = new JTextField(10);
		blabel = new JLabel("x : ");
		b = new JTextField(10);

		alabel.setBounds(this.getX(), this.getY() - (bound), shift, 25);
		a.setBounds(this.getX() + shift, this.getY() - (bound), shift, 25);

		blabel.setBounds(this.getX(), this.getY() - (bound - 30), shift, 25);
		b.setBounds(this.getX() + shift, this.getY() - (bound - 30), shift, 25);

		add(alabel);
		add(blabel);
		add(a);
		add(b);

		// ADD TABLE PANEL
		tablePanel = new TablePanel(new String[STATIC_LENGTH.MAX_ITERATION][2],
				new String[] { " p ", " f(p) " });

		add(tablePanel);

		// ADD DRAW PANEL
		drawPanel = new DrawPanel();
		add(drawPanel);

		// setting model elements
		model = controller.getModel();
		model.setDrawPanel(drawPanel);
		model.setTablePanel(tablePanel);

		setFocusable(true);
		requestDefaultFocus();
		requestFocus();

	}

	public void activateStart(boolean activate) {
		if (activate)
			start.setEnabled(true);
		else
			start.setEnabled(false);
	}

	public void activateNext(boolean activate) {
		if (activate)
		{
			next.setEnabled(true);
			runAll.setEnabled(true);
		}
		else
		{
			next.setEnabled(false);
			runAll.setEnabled(false);
		}
	}

	class NewtonRaphsonAccActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			double p = 0, x = 0;
			try {
				p = Double.parseDouble(a.getText());
				x = Double.parseDouble(b.getText());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid arguments");

				return;
			}
			;
			try {
				if (event.getActionCommand().equalsIgnoreCase("Start")) {

					String[] inputs = controller.getBackGroundPanel().Data();
					Arrays.toString(inputs);
					model.setFunction(inputs[0]);
					model.setPrecision(Double.parseDouble(inputs[1]));
					model.setMaxIteration(Integer.parseInt(inputs[2]));
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid inputs");
			}
			controller.action(event, p, x);

		}
	}

}
