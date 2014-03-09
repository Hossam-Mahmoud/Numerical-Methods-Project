package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.BisectionController;
import controller.FalsePositionController;
import controller.FixedPointController;
import controller.NewtonRaphsonAccController;
import controller.NewtonRaphsonController;
import controller.SecantController;

import model.STATIC_LENGTH;

@SuppressWarnings("serial")
public class BackGroundPanel extends JPanel {
	JTabbedPane tab;
	InputPanel inputPanel;
	BisectionPanel bisectionPanel;

	FalsePositionPanel falsePositionPanel;
	FixedPointPanel fixedPointPanel;
	NewtonRaphsonPanel newtonRaphsonPanel;
	NewtonRaphsonAcceleratedPanel newtonRaphsonAccPanel;
	SecantPanel secantPanel;

	@SuppressWarnings("deprecation")
	public BackGroundPanel(BisectionController bisectionController,
			FalsePositionController falsePosController,
			FixedPointController fixedPointController,
			NewtonRaphsonController newtonRaphsonController,
			NewtonRaphsonAccController newtonRaphsonAccController,
			SecantController secantController) {
		super();
		setLayout(null);

		// input Panel
		inputPanel = new InputPanel(this);
		add(inputPanel);

		// tab and other output Panels
		tab = new JTabbedPane();
		tab.setBounds(STATIC_LENGTH.TAB_X, STATIC_LENGTH.TAB_Y,
				STATIC_LENGTH.TAB_WIDTH, STATIC_LENGTH.TAB_HEIGHT);

		// bisection tab
		bisectionPanel = new BisectionPanel(bisectionController);
		bisectionPanel.activateNext(false);
		tab.add("Bisection Method", bisectionPanel);

		// false position tab
		falsePositionPanel = new FalsePositionPanel(falsePosController);
		falsePositionPanel.activateNext(false);
		tab.add("False position Method", falsePositionPanel);

		// fixed point iteration tab
		fixedPointPanel = new FixedPointPanel(fixedPointController);
		fixedPointPanel.activateNext(false);
		tab.add("Fixed point iteration Method", fixedPointPanel);

		// newton Raphson tab
		newtonRaphsonPanel = new NewtonRaphsonPanel(newtonRaphsonController);
		newtonRaphsonPanel.activateNext(false);
		tab.add("Newton Raphson Method", newtonRaphsonPanel);

		// newton raphson accelerated tab
		newtonRaphsonAccPanel = new NewtonRaphsonAcceleratedPanel(
				newtonRaphsonAccController);
		newtonRaphsonAccPanel.activateNext(false);
		tab.add("newton Raphson Accelerated Method", newtonRaphsonAccPanel);

		// secant Panel
		secantPanel = new SecantPanel(secantController);
		secantPanel.activateNext(false);
		tab.add("Secant Method", secantPanel);

		add(tab);

		setFocusable(true);
		requestDefaultFocus();
		requestFocus();

	}

	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public BisectionPanel getBisectionPanel() {
		return bisectionPanel;
	}

	public FalsePositionPanel getFalsePositionPanel() {
		return falsePositionPanel;
	}

	public FixedPointPanel getFixedPointPanel() {
		return fixedPointPanel;
	}

	public NewtonRaphsonPanel getNewtonRaphsonPanel() {
		return newtonRaphsonPanel;
	}

	public NewtonRaphsonAcceleratedPanel getNewtonRaphsonAccPanel() {
		return newtonRaphsonAccPanel;
	}

	public SecantPanel getSecantPanel() {
		return secantPanel;
	}

	public static void main(String[] args) {
		// Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		// JFrame frame = new JFrame("yalla");
		// BackGroundPanel bg = new BackGroundPanel();
		// frame.add(bg);
		// frame.pack();
		// frame.setSize(screen.width, screen.height);
		// frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public String[] Data() {
		return new String[] { inputPanel.functionTF.getText(),
				inputPanel.precisionTF.getText(),
				inputPanel.maxIterationTF.getText() };
	}
}
