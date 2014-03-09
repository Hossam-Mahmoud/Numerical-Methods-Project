package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import Function.Function;
import Function.Parser;

import model.STATIC_LENGTH;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {

	JLabel functionLabel;
	JTextField functionTF;
	JLabel precisionLabel;
	JTextField precisionTF;
	JLabel maxIterationLabel;
	JTextField maxIterationTF;
	JButton plotButton;
	JButton readFile;
	BackGroundPanel backgroundPanel;

	public InputPanel(BackGroundPanel bgPanel) {
		super();
		setLayout(null);
		backgroundPanel = bgPanel;
		int stx = STATIC_LENGTH.START_HEADER_X, sty = STATIC_LENGTH.START_BACKGROUND_Y, width = STATIC_LENGTH.HEADER_WIDTH, height = STATIC_LENGTH.HEADER_HEIGHT;

		setBounds(stx, sty, width, height);

		functionLabel = new JLabel("  Function   ");
		functionLabel.setBounds(stx, sty, width / 4, height / 3);
		add(functionLabel);

		functionTF = new JTextField(15);
		functionTF.setText("");
		functionTF.setBounds(functionLabel.getWidth(), functionLabel.getY(),
				functionLabel.getWidth(), functionLabel.getHeight());
		add(functionTF);

		// add plot button
		plotButton = new JButton("Plot !");
		plotButton.setBounds(functionTF.getX() + functionTF.getWidth(),
				functionTF.getY(), functionTF.getWidth() / 2,
				functionTF.getHeight());

		InputPanelActions action = new InputPanelActions();
		plotButton.addActionListener(action);
		add(plotButton);

		// add precision elements
		precisionLabel = new JLabel("  Precision  ");
		precisionLabel.setBounds(stx, sty + functionLabel.getHeight(),
				width / 4, height / 3);
		add(precisionLabel);

		precisionTF = new JTextField(15);
		precisionTF.setText("0.00001");
		precisionTF.setBounds(precisionLabel.getWidth(), precisionLabel.getY(),
				100, precisionLabel.getHeight());
		add(precisionTF);

		maxIterationLabel = new JLabel("  Max Iteration  ");
		maxIterationLabel.setBounds(stx, sty + functionLabel.getHeight()
				+ precisionLabel.getHeight(), width / 4, height / 3);
		add(maxIterationLabel);

		maxIterationTF = new JTextField(15);
		maxIterationTF.setText("50");
		maxIterationTF.setBounds(maxIterationLabel.getWidth(),
				maxIterationLabel.getY(), 100, maxIterationLabel.getHeight());
		add(maxIterationTF);

		// read from file button
		readFile = new JButton("Read from file");
		readFile.setBounds(plotButton.getX() + 460, maxIterationTF.getY(),
				plotButton.getWidth(), maxIterationTF.getHeight());
		readFile.addActionListener(action);
		add(readFile);

		setBackground(Color.gray);

		setFocusable(true);
		requestFocus();

	}

	class InputPanelActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			if (name.equalsIgnoreCase(plotButton.getText())) {
				try {
					Parser p = new Parser();
					Function f = p.parse(functionTF.getText());

					backgroundPanel.getBisectionPanel().drawPanel
							.setFunction(f);

					backgroundPanel.getFalsePositionPanel().drawPanel
							.setFunction(f);
					backgroundPanel.getFixedPointPanel().drawPanel
							.setFunction(f);
					backgroundPanel.getNewtonRaphsonPanel().drawPanel
							.setFunction(f);
					backgroundPanel.getNewtonRaphsonAccPanel().drawPanel
							.setFunction(f);
					backgroundPanel.getSecantPanel().drawPanel.setFunction(f);
					requestDefaultFocus();
					requestFocus();
					setFocusable(true);
				} catch (Exception q) {
					System.out.println("error at inputPanel Actions");
				}
			} else if (name.equalsIgnoreCase(readFile.getText())) {
				try{
					FileDialog fd = new FileDialog(new Shell(), SWT.OPEN);
					fd.setFilterNames(new String[] { "ALL Files " });
					fd.setFilterExtensions(new String[] { "*.*" });
					String path = fd.open();
					try {
						boolean ans = intiateWithFile(path);
						if (!ans)
							JOptionPane.showMessageDialog(null, "INVALID FILE");
						else
							JOptionPane
									.showMessageDialog(null, "DONE SUCCESSFULLY");
					} catch (IOException q) {
						JOptionPane.showMessageDialog(null, "INVALID FILE");
					}
				}catch(Exception e2){
					
				}

				requestDefaultFocus();
				requestFocus();
				setFocusable(true);
			}

		}

		private boolean intiateWithFile(String path) throws IOException {
			Scanner in = new Scanner(new FileReader(path));
			String function = in.next();
			String precision = in.next();
			String maxIteration = in.next();

			functionTF.setText(function);
			precisionTF.setText(precision);
			maxIterationTF.setText(maxIteration);

			while (in.hasNext()) {
				int tabNo = in.nextInt();
				if (tabNo == 0) {
					backgroundPanel.bisectionPanel.a.setText(in.next());
					backgroundPanel.bisectionPanel.b.setText(in.next());
				} else if (tabNo == 1) {
					backgroundPanel.falsePositionPanel.a.setText(in.next());
					backgroundPanel.falsePositionPanel.b.setText(in.next());
				} else if (tabNo == 2) {
					backgroundPanel.fixedPointPanel.a.setText(in.next());
				} else if (tabNo == 3) {
					backgroundPanel.newtonRaphsonPanel.a.setText(in.next());
				} else if (tabNo == 4) {
					backgroundPanel.newtonRaphsonAccPanel.a.setText(in.next());
					backgroundPanel.newtonRaphsonAccPanel.b.setText(in.next());
				} else if (tabNo == 5) {
					backgroundPanel.secantPanel.a.setText(in.next());
					backgroundPanel.secantPanel.b.setText(in.next());
				}
			}
			return true;
		}
	}

}
