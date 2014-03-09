package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.Model;
import view.BackGroundPanel;
import controller.BisectionController;
import controller.FalsePositionController;
import controller.FixedPointController;
import controller.NewtonRaphsonAccController;
import controller.NewtonRaphsonController;
import controller.SecantController;

public class PartOneMain {
	public static void main(String[] args) {

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		BisectionController contrl = new BisectionController(new Model());
		FalsePositionController contrl2 = new FalsePositionController(
				new Model());
		FixedPointController contrl3 = new FixedPointController(new Model());
		NewtonRaphsonController contrl4 = new NewtonRaphsonController(
				new Model());
		NewtonRaphsonAccController contrl5 = new NewtonRaphsonAccController(
				new Model());
		SecantController contrl6 = new SecantController(new Model());

		JFrame frame = new JFrame("yalla");
		BackGroundPanel bg = new BackGroundPanel(contrl, contrl2, contrl3,
				contrl4, contrl5, contrl6);

		contrl.setBackGroundPanel(bg);
		contrl2.setBackGroundPanel(bg);
		contrl3.setBackGroundPanel(bg);
		contrl4.setBackGroundPanel(bg);
		contrl5.setBackGroundPanel(bg);
		contrl6.setBackGroundPanel(bg);

		frame.add(bg);
		frame.pack();
		frame.setSize(screen.width, screen.height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
