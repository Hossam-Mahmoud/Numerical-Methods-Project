package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Function.Function;
import GUI.Plot;

import model.STATIC_LENGTH;

public class DrawPanel extends JPanel {

	JButton zoomIn, zoomOut, reset;
	Plot plot;

	public DrawPanel() {
		super();
		setLayout(null);
		setBounds(STATIC_LENGTH.DRAW_X, STATIC_LENGTH.DRAW_Y - 100,
				STATIC_LENGTH.DRAW_WIDTH, STATIC_LENGTH.DRAW_HEIGHT);
		

		zoomIn = new JButton("Zoom in");
		zoomOut = new JButton("Zoom out");
		reset = new JButton("Reset");

		int horizontalShift = 100;
		int verticalShift = 50;
		int delta = 30;
		zoomIn.setBounds(delta + STATIC_LENGTH.DRAW_X,
				STATIC_LENGTH.DRAW_Y - 100, horizontalShift, verticalShift);
		zoomOut.setBounds(delta + STATIC_LENGTH.DRAW_X + zoomIn.getWidth(),
				STATIC_LENGTH.DRAW_Y - 100, horizontalShift, verticalShift);
		reset.setBounds(zoomOut.getX() + zoomOut.getWidth(),
				STATIC_LENGTH.DRAW_Y - 100, horizontalShift, verticalShift);

		DrawPanelActions actions = new DrawPanelActions();
		zoomIn.addActionListener(actions);
		zoomOut.addActionListener(actions);
		reset.addActionListener(actions);

		add(zoomIn);
		add(zoomOut);
		add(reset);

		try {
			plot = new Plot(STATIC_LENGTH.DRAW_WIDTH - 300,
					STATIC_LENGTH.DRAW_HEIGHT - 250);
			plot.setLocation(STATIC_LENGTH.DRAW_X - 150, STATIC_LENGTH.DRAW_Y);
			plot.setBorder(new LineBorder(Color.black));
			this.add(plot);

		} catch (Exception e) {
			// handle repaint when start
		}

		setFocusable(true);
		requestDefaultFocus();
		requestFocus();
	}

	public void setFunction(Function f) {
		plot.setFunction(f);
		plot.setLine(null);
		plot.setPoints(null, null);
		plot.repaint();
	}

	public void setPoints(double[] x, double[] y) {
		plot.setPoints(x, y);
		plot.repaint();
	}

	public void drawLine(Function line){
		plot.setLine(line);
	}
	
	class DrawPanelActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();

			if (name.equalsIgnoreCase("Zoom in")) {
				plot.zoomIn();
			} else if (name.equalsIgnoreCase("Zoom out")) {
				plot.zoomOut();
			} else if (name.equalsIgnoreCase("Reset")) {
				plot.reset();
			}

		}
	}
}