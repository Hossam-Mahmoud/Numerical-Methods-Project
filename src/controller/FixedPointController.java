package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import partOne.FixedPoint;
import model.Model;
import view.BackGroundPanel;
import view.DrawPanel;
import view.TablePanel;
import Function.Function;
import Function.Parser;

public class FixedPointController {
	// answers
	private double[][] answer;
	// complete Answers
	private double[][] completeAnswer;
	// next Iterator
	private int NextIter;

	// problems
	private FixedPoint FixedPoint;

	private Model model;
	private BackGroundPanel backGroundPanel;
	private DrawPanel drawPanel;
	private TablePanel tablePanel;

	public FixedPointController(Model model) {
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setBackGroundPanel(BackGroundPanel backGroundPanel) {
		this.backGroundPanel = backGroundPanel;
	}

	public BackGroundPanel getBackGroundPanel() {
		return backGroundPanel;
	}

	public void action(ActionEvent event, double p) {
		String name = event.getActionCommand();
		tablePanel = model.getTablePanel();
		drawPanel = model.getDrawPanel();

		if (name.equalsIgnoreCase("Start")) {
			// // clear table and drawpanel
			tablePanel.removeAll();
			// create function
			Parser parser = new Parser();
			Function f = parser.parse(model.getFunction());

			FixedPoint = new FixedPoint(f, model.getPrecision(),
					model.getMaxIteration());
			FixedPoint.doAlgo(p);
			completeAnswer = FixedPoint.getAnswer();
			if (completeAnswer == null) {
				JOptionPane.showMessageDialog(null,
						"start point doesn't lead to answer");
				return;
			}
			answer = new double[FixedPoint.getIterations()][4];
			answer[0] = completeAnswer[0];
			NextIter = 1;
			// enable next button
			backGroundPanel.getFixedPointPanel().activateNext(true);

			// ploting
			drawPanel.setFunction(f);
			drawPanel.setPoints(new double[] { answer[0][0] },
					new double[] { answer[0][1] });
			drawPanel.drawLine(parser.parse("x"));

		} else if (name.equalsIgnoreCase("next")) {
			doNext();
		} else if (name.equalsIgnoreCase("Run All")) {
			while (NextIter != answer.length) {
				doNext();
			}
		}

		tablePanel.requestDefaultFocus();
		tablePanel.requestFocus();
		tablePanel.setFocusable(true);
		tablePanel.setData(answer, NextIter);

		tablePanel.requestDefaultFocus();
		tablePanel.requestFocus();
		tablePanel.setFocusable(true);

		if (NextIter == answer.length) {
			// end and show answer
			// disable next button
			backGroundPanel.getFixedPointPanel().activateNext(false);
			JOptionPane.showMessageDialog(null, FixedPoint.getMessage(),
					"Finished", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	private void doNext() {
		tablePanel.removeAll();
		if (FixedPoint == null) {
			JOptionPane.showMessageDialog(null, "ERROR");
			answer = completeAnswer;
			NextIter = answer.length - 1;

		} else if (NextIter < FixedPoint.getIterations()) {
			answer[NextIter] = completeAnswer[NextIter];
		} else {
			JOptionPane.showMessageDialog(null, "done");
			answer = completeAnswer;
			NextIter = answer.length - 1;
		}

		if (NextIter != answer.length - 1) {
			// ploting
			drawPanel.setPoints(new double[] { answer[NextIter][0] },
					new double[] { answer[NextIter][1] });
			drawPanel.drawLine((new Parser()).parse("x"));

		}

		NextIter++;

	}

}
