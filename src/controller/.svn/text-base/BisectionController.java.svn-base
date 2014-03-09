package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Function.Function;
import Function.Parser;

import partOne.Bisection;

import model.Model;
import view.BackGroundPanel;
import view.DrawPanel;
import view.TablePanel;

public class BisectionController {

	// answers
	private double[][] answer;
	// complete Answers
	private double[][] completeAnswer;
	// next Iterator
	private int NextIter;

	// problems
	private Bisection bisection;

	private Model model;
	private BackGroundPanel backGroundPanel;
	private TablePanel tablePanel;
	private DrawPanel drawPanel;

	public BisectionController(Model model) {
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

	public void action(ActionEvent event, double a, double b) {
		String name = event.getActionCommand();
		tablePanel = model.getTablePanel();
		drawPanel = model.getDrawPanel();
		if (name.equalsIgnoreCase("Start")) {
			// // clear table and drawpanel
			tablePanel.removeAll();
			// create function
			Parser parser = new Parser();
			Function f = parser.parse(model.getFunction());

			bisection = new Bisection(f, model.getPrecision(),
					model.getMaxIteration());
			bisection.doAlgo(a, b);
			completeAnswer = bisection.getAnswer();
			if (completeAnswer == null) {
				JOptionPane.showMessageDialog(null,
						"interval don't lead to answer");
				return;
			}
			answer = new double[bisection.getIterations()][4];
			answer[0] = completeAnswer[0];
			NextIter = 1;

			// enable next button
			backGroundPanel.getBisectionPanel().activateNext(true);

			// ploting
			drawPanel.setFunction(f);
			drawPanel.setPoints(new double[] { answer[0][0], answer[0][1],
					answer[0][2] }, new double[] { 0, 0, answer[0][3] });

		} else if (name.equalsIgnoreCase("next")) {
			doNext();
		} 
		else if (name.equalsIgnoreCase("Run All")) {
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
			backGroundPanel.getBisectionPanel().activateNext(false);
			JOptionPane.showMessageDialog(null, bisection.getMessage(),
					"Finished", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void doNext() {
		tablePanel.removeAll();
		if (bisection == null) {
			JOptionPane.showMessageDialog(null, "ERROR");
			answer = completeAnswer;
			NextIter = answer.length - 1;

		} else if (NextIter < bisection.getIterations()) {
			answer[NextIter] = completeAnswer[NextIter];
		} else {
			JOptionPane.showMessageDialog(null, "done");
			answer = completeAnswer;
			NextIter = answer.length - 1;
		}

		if (NextIter != answer.length - 1) {
			// ploting
			drawPanel.setPoints(new double[] { answer[NextIter][0],
					answer[NextIter][1], answer[NextIter][2] }, new double[] {
					0, 0, answer[NextIter][3] });

		}

		NextIter++;

	}

}
