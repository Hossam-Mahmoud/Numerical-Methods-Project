package model;

import view.DrawPanel;
import view.TablePanel;

public class Model implements ModelIF {

	private String function;
	private double precision;
	private int maxIteration;

	// table and draw panels
	private DrawPanel DrawPanel;
	private TablePanel TablePanel;

	public Model() {
		// TODO Auto-generated constructor stub
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public int getMaxIteration() {
		return maxIteration;
	}

	public void setMaxIteration(int maxIteration) {
		this.maxIteration = maxIteration;
	}

	public DrawPanel getDrawPanel() {
		return DrawPanel;
	}

	public void setDrawPanel(DrawPanel drawPanel) {
		this.DrawPanel = drawPanel;
	}

	public TablePanel getTablePanel() {
		return TablePanel;
	}

	public void setTablePanel(TablePanel tablePanel) {
		this.TablePanel = tablePanel;
	}

}
