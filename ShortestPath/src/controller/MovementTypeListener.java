package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model_bll.ShortestPathModel;
import view.ShortestPathView;

public class MovementTypeListener implements ActionListener
{
	private ShortestPathView theView;
	private ShortestPathModel theModel;
	
	MovementTypeListener(ShortestPathView v, ShortestPathModel m)
	{
		this.theView = v;
		this.theModel = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			ShortestPathModel.changeNeighbours(theView.pButtons.swapMovementText());		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}		
}