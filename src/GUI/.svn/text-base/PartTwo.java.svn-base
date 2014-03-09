package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import partTwo.Lagrange;
import partTwo.NewtonsDivide;
import Function.Function;
import Function.Parser;

public class PartTwo extends JPanel {
	private JTextField textField;
	private ArrayList<JTextField> Xtexts;
	private ArrayList<JTextField> Ftexts;
	private double[] points;
	private double[] funPoints;
	private JTextArea res;
	private JTextArea res2;
	private JPanel panel;
	private JScrollPane scrollPane_2;
	private JPanel panela;
	private JFrame parent;
	private Lagrange lag;
	private NewtonsDivide newtn;
	private Parser prs;
	private Plot panel_1;
	private Plot panel_2;
	private JTextField textField_1;
	
	public void setParent(JFrame prnt){
		parent = prnt;
	}
	
	
	private void setArrays(){
		points = new double[Xtexts.size()];
		funPoints = new double[Ftexts.size()];
		for(int i =0; i<points.length; i++){
			points[i] = Double.parseDouble(Xtexts.get(i).getText());
			funPoints[i] = Double.parseDouble(Ftexts.get(i).getText());
		}
	}
	
	public PartTwo() {
		panela = new JPanel();
		
		panela.setLayout(new BoxLayout(panela, BoxLayout.LINE_AXIS));
		panela.setBounds(60, 54, 1278, 73);
		add(panela);
		scrollPane_2  = new JScrollPane();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		scrollPane_2.setViewportView(panel);
		panela.add(scrollPane_2, null);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		scrollPane_2.setViewportView(panel);
		
		

		JButton btnNewButton = new JButton("Generate table");
		btnNewButton.setBounds(757, 11, 105, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int num = Integer.parseInt(textField.getText());
					int num2 = num*2;
					
					panela.remove(scrollPane_2);
					scrollPane_2.remove(panel);
					panel.removeAll();
					remove(panela);
					
					Xtexts = new  ArrayList<JTextField>();
					Ftexts = new ArrayList<JTextField>();
					scrollPane_2.setVisible(false);
					panel = new JPanel();
					panel.setLayout(new GridLayout(2, num/2));
					while(num2>0){
						JTextField text = new JTextField();
						text.setColumns(5);
						panel.add(text);
						if(num2>(num)){
							Xtexts.add(text);
						}else{
							Ftexts.add(text);
						}
						num2--;
					}
					scrollPane_2 = new JScrollPane(panel);
					panela.add(scrollPane_2, BorderLayout.NORTH);
					add(panela);
					parent.repaint();
					
				}catch(Exception e){
					textField.setText("Wrong input");
				}
				
			}
		});
		setLayout(null);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(642, 12, 105, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of points");
		lblEnterNumberOf.setBounds(516, 11, 116, 23);
		add(lblEnterNumberOf);
		
		JLabel lblX = new JLabel("X =");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX.setBounds(10, 54, 46, 33);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblX);
		
		JLabel lblFx = new JLabel("f(x) =");
		lblFx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFx.setBounds(10, 94, 46, 33);
		lblFx.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblFx);
		
		JButton btnLagrange = new JButton("Lagrange ");
		btnLagrange.setBounds(294, 138, 89, 23);
		btnLagrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					setArrays();
					lag = new Lagrange(points, funPoints, points.length);
					res.setVisible(true);
					String tmp = lag.interpolate();
					if(tmp.contains("Infinity")){
						res.setText("Can't interpolate, division by zero");
						lag = null;
					}
					else
						res.setText(tmp);
				}catch(Exception e){
					
				}
			}
		});
		add(btnLagrange);
		
		JButton btnNewtonsDividedDiffrence = new JButton("Newton's divided diffrence");
		btnNewtonsDividedDiffrence.setBounds(926, 138, 168, 23);
		btnNewtonsDividedDiffrence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					setArrays();
					newtn = new NewtonsDivide(points, funPoints, points.length);
					res2.setVisible(true);
					String tmp = newtn.interpolate();
					if(tmp.contains("Infinity")){
						res2.setText("Can't interpolate, division by zero");
						newtn = null;
					}
					else
						res2.setText(tmp);
				}catch(Exception e){
					
				}
			}
		});
		add(btnNewtonsDividedDiffrence);
		
		res2 = new JTextArea();
		res2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		res2.setBorder(new LineBorder(new Color(0, 0, 0)));
		res2.setLineWrap(true);
		res2.setBounds(680, 141, 650, 81);
		res2.setVisible(false);
		
		res = new JTextArea();
		res.setWrapStyleWord(true);
		res.setFont(new Font("Tahoma", Font.PLAIN, 15));
		res.setBorder(new LineBorder(new Color(0, 0, 0)));
		res.setLineWrap(true);
		res.setBounds(10, 141, 650, 81);
		res.setVisible(false);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 167, 655, 81);
		add(scrollPane);
		scrollPane.add(res);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(683, 167, 655, 81);
		add(scrollPane_1);
		scrollPane_1.add(res2);
		
		prs = new Parser();
		
		panel_1 = new Plot(655, 283);
		panel_1.setBounds(10, 282, 655, 283);
		panel_1.setBorder(new LineBorder(Color.black));
		add(panel_1);
		
		JButton btnDrawSteps = new JButton("Draw Steps");
		btnDrawSteps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String tmp = lag.getNext();
					Function f = prs.parse(tmp);
					panel_1.setFunction(f);
					panel_1.setPoints(points, funPoints);
					panel_1.repaint();
				}catch(Exception e){
					
				}
			}
		});
		btnDrawSteps.setBounds(286, 254, 116, 23);
		add(btnDrawSteps);
		
		panel_2 = new Plot(644, 283);
		panel_2.setBounds(694, 282, 644, 283);
		panel_2.setBorder(new LineBorder(Color.black));
		add(panel_2);
		
		JButton button = new JButton("Draw Steps");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					panel_2.setFunction(prs.parse(newtn.getNext()));
					panel_2.setPoints(points, funPoints);
					panel_2.repaint();
				}catch(Exception e){
					
				}
			}
		});
		button.setBounds(961, 254, 105, 23);
		add(button);
		
		JButton btnZoomIn = new JButton("Zoom in");
		btnZoomIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.zoomIn();
				panel_2.zoomIn();
				
			}
		});
		btnZoomIn.setBounds(526, 576, 89, 23);
		add(btnZoomIn);
		
		JButton btnZoomOut = new JButton("Zoom out");
		btnZoomOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.zoomOut();
				panel_2.zoomOut();
			}
		});
		btnZoomOut.setBounds(642, 576, 89, 23);
		add(btnZoomOut);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.reset();
				panel_2.reset();
			}
		});
		btnReset.setBounds(757, 576, 89, 23);
		add(btnReset);
		
		final JLabel lblEn = new JLabel("En =");
		lblEn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEn.setBounds(790, 625, 197, 33);
		add(lblEn);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(598, 627, 182, 33);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblOriginalFunction = new JLabel("Original Function :");
		lblOriginalFunction.setHorizontalAlignment(SwingConstants.CENTER);
		lblOriginalFunction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOriginalFunction.setBounds(458, 625, 130, 33);
		add(lblOriginalFunction);
		
		JButton btnComputeBoundError = new JButton("Compute bound Error");
		btnComputeBoundError.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String fun = textField_1.getText();
					Function f = getDerivative(fun);
					double maxFromDef = getMax(f);
					String coff ="";
					for(int i=0; i<points.length-1; i++){
						if(points[i]< 0){
							coff += "(x+"+(-1*points[i])+")*";
						}else
							coff += "(x-"+points[i]+")*";
					}
					coff = coff.substring(0, coff.length()-1);
					Function f2 = prs.parse(coff);
					double maxFromCoff = getMax(f2);
					double res = (maxFromCoff*maxFromDef)/(factorial(points.length));
					lblEn.setText("E"+(points.length-1)+" = "+res);
				}catch(Exception e){
					
				}
				
				
			}
		});
		btnComputeBoundError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnComputeBoundError.setBounds(294, 626, 162, 33);
		add(btnComputeBoundError);
		
		JButton btnReadFromFile = new JButton("Read from file");
		btnReadFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser fc = new JFileChooser();
					fc.showOpenDialog(new JFrame());
					File f = fc.getSelectedFile();
					Scanner sc = new Scanner(f);
					ArrayList<String> arr = new ArrayList<String>();
					while(sc.hasNext()){
						arr.add(sc.next());
					}
					sc.close();
					if(arr.size()%2 != 0){
						JOptionPane.showMessageDialog(null, "Invalid File Format",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						int num2 = arr.size();
						int num = num2/2;
						panela.remove(scrollPane_2);
						scrollPane_2.remove(panel);
						panel.removeAll();
						remove(panela);
						Xtexts = new  ArrayList<JTextField>();
						Ftexts = new ArrayList<JTextField>();
						scrollPane_2.setVisible(false);
						panel = new JPanel();
						panel.setLayout(new GridLayout(2, num2/2));
						int i =0;
						while(num2>0){
							JTextField text = new JTextField();
							text.setColumns(5);
							text.setText(arr.get(i));
							panel.add(text);
							if(num2>(num)){
								Xtexts.add(text);
							}else{
								Ftexts.add(text);
							}
							num2--;
							i++;
						}
						scrollPane_2 = new JScrollPane(panel);
						panela.add(scrollPane_2, BorderLayout.NORTH);
						add(panela);
						parent.repaint();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid File Format",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnReadFromFile.setBounds(909, 11, 105, 23);
		add(btnReadFromFile);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(872, 15, 27, 14);
		add(lblOr);
		
	}
	
	public Function getDerivative(String func){
		Function f = prs.parse(func);
		for(int i=0; i<points.length; i++){
			f = f.differentiate();
		}
		return f;
	}
	
	public double getMax(Function f){
		double[] temp = new double[points.length];
		System.arraycopy(points, 0, temp, 0, points.length);
		Arrays.sort(temp);
		double max = 0;
		for(double i= temp[0]; i<= temp[temp.length-1]; i +=0.0001){
			double tmpNum = Math.abs(f.evaluate(i));
			if(i == temp[0]){
				max = tmpNum;
			}else if(max < tmpNum){
				max = tmpNum;
			}
		}
		return max;
	}
	
	public int factorial(int i){
		int res=1;
		while(i>1){
			res *=i;
			i--;
		}
		return res;
	}
	
	
}
