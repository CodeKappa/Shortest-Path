package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LegendPanel extends JPanel
{
	LegendPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	  public void paintComponent(Graphics g)
	  { 
		 super.paintComponent(g);
		 g.drawString("Legend",10,10); 
		 g.drawString("Red   - Start",100,10); 
		 g.drawString("Yellow - Finish",100,22); 
		 g.drawString("Black  - Obstacle",100,34); 
		 g.drawString("Grey    - Path",100,45);
		 
		 g.drawString("INPUT",340,10); 
		 g.drawString("Number of rows, number of columns",400,10); 
		 g.drawString("Two pairs (x y) signifying the start and finish positions",400,22); 
		 g.drawString("N pairs of obstacles (x y)",400,34); 
		 g.drawString("All data must be separated by at least one white character and only by white characters",400,45); 
	  }
	 
	
	public Dimension getPreferredSize()
	{
		return new Dimension(1250, 50);
	}
}