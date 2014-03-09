package model;

import view.DrawPanel;
import view.TablePanel;

public interface ModelIF {

	public String getFunction();

	public void setFunction(String function);

	public double getPrecision();

	public void setPrecision(double precision);

	public int getMaxIteration();

	public void setMaxIteration(int maxIteration);

	public DrawPanel getDrawPanel();

	public void setDrawPanel(DrawPanel DrawPanel);

	public TablePanel getTablePanel();

	public void setTablePanel(TablePanel tablePanel);

}
