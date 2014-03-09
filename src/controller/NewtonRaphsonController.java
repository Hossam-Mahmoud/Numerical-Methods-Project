package controller;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import partOne.NewtonRaphson;

import model.Model;

import view.BackGroundPanel;
import view.DrawPanel;
import view.TablePanel;
import Function.Function;
import Function.Parser;

public class NewtonRaphsonController {

	// answers
	private double[][] answer;
	// complete Answers
	private double[][] completeAnswer;
	// next Iterator
	private int NextIter;

	// problems
	private NewtonRaphson newtonRaphson;

	private Model model;
	private BackGroundPanel backGroundPanel;

	private TablePanel tablePanel;
	private DrawPanel drawPanel;

	public NewtonRaphsonController(Model model) {
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

			newtonRaphson = new NewtonRaphson(f, model.getPrecision(),
					model.getMaxIteration());
			newtonRaphson.doAlgo(p);
			completeAnswer = newtonRaphson.getAnswer();
			if (completeAnswer == null) {
				JOptionPane.showMessageDialog(null,
						"start point doesn't lead to answer");
				return;
			}
			answer = new double[newtonRaphson.getIterations()][4];
			answer[0] = completeAnswer[0];
			NextIter = 1;
			// enable next button
			backGroundPanel.getNewtonRaphsonPanel().activateNext(true);

			// ploting
			drawPanel.setFunction(f);
			drawPanel.setPoints(new double[] { answer[0][0] },
					new double[] { answer[0][1] });

			if (completeAnswer.length > 1) {
				drawSlopeLine(0);
			}

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
			backGroundPanel.getNewtonRaphsonPanel().activateNext(false);
			JOptionPane.showMessageDialog(null, newtonRaphson.getMessage(),
					"Finished", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void doNext() {
		tablePanel.removeAll();
		if (newtonRaphson == null) {
			JOptionPane.showMessageDialog(null, "ERROR");
			answer = completeAnswer;
			NextIter = answer.length - 1;

		} else if (NextIter < newtonRaphson.getIterations()) {
			answer[NextIter] = completeAnswer[NextIter];
		} else {
			JOptionPane.showMessageDialog(null, "done");
			answer = completeAnswer;
			NextIter = answer.length - 1;
		}

		// ploting
		if (NextIter != answer.length - 1) {
			drawPanel.setPoints(new double[] { answer[NextIter][0] },
					new double[] { answer[NextIter][1] });
			// there is next point
			if (NextIter + 1 < completeAnswer.length) {
	
				drawSlopeLine(NextIter);
			}

		}

		NextIter++;

	}

	private void drawSlopeLine(int i) {
		double xi = completeAnswer[i][0];
		double fxi = completeAnswer[i][1];
		double xiplus1 = completeAnswer[i + 1][0];

		String expression = "(x-" + new BigDecimal(xi).toPlainString() + ")*("
				+ new BigDecimal((fxi / (xi - xiplus1))).toPlainString() + ")+"
				+ new BigDecimal(fxi).toPlainString();
		drawPanel.drawLine(new Parser().parse(expression));

	}
}
