package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model_bll.Problem;
import model_bll.ShortestPathModel;
import view.ShortestPathView;

public class SearchListener implements ActionListener
{
	private ShortestPathView theView;
	private ShortestPathModel theModel;
	
	SearchListener(ShortestPathView v, ShortestPathModel m)
	{
		this.theView = v;
		this.theModel = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String input;
		try
		{
			input = theView.pData.getData();
			Problem problem = ShortestPathModel.parseData(input);
			theView.pMaze.setOutput(theModel.findShortestPath(problem));			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}		
}