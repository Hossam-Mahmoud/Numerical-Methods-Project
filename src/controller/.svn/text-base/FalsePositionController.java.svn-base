package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import model.Model;
import partOne.FalsePosition;
import view.BackGroundPanel;
import view.DrawPanel;
import view.TablePanel;
import Function.Function;
import Function.Parser;

public class FalsePositionController {

	// answers
	private double[][] answer;
	// complete Answers
	private double[][] completeAnswer;
	// next Iterator
	private int NextIter;

	// problems
	private FalsePosition falsePosition;

	private Model model;
	private BackGroundPanel backGroundPanel;
	private DrawPanel drawPanel;
	private TablePanel tablePanel;

	public FalsePositionController(Model model) {
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

			falsePosition = new FalsePosition(f, model.getPrecision(),
					model.getMaxIteration());
			falsePosition.doAlgo(a, b);
			completeAnswer = falsePosition.getAnswer();
					
			if (completeAnswer == null) {
				JOptionPane.showMessageDialog(null,
						"interval don't lead to answer");
				return;
			}
			answer = new double[falsePosition.getIterations()][4];
			answer[0] = completeAnswer[0];
			NextIter = 1;
			// enable next button
			backGroundPanel.getFalsePositionPanel().activateNext(true);
			// ploting
			drawPanel.setFunction(f);
			drawPanel.setPoints(new double[] { answer[0][0], answer[0][1],
					answer[0][2] }, new double[] { 0, 0, answer[0][3] });

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
			backGroundPanel.getFalsePositionPanel().activateNext(false);
			JOptionPane.showMessageDialog(null, falsePosition.getMessage(),
					"Finished", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void doNext() {
		tablePanel.removeAll();
		if (falsePosition == null) {
			JOptionPane.showMessageDialog(null, "ERROR");
			answer = completeAnswer;
			NextIter = answer.length - 1;

		} else if (NextIter < falsePosition.getIterations()) {
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
