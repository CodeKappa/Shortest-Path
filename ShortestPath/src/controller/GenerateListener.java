package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model_bll.ModelOut;
import model_bll.Problem;
import model_bll.ShortestPathModel;
import view.ShortestPathView;

public class GenerateListener implements ActionListener
{

	private ShortestPathView theView;
	private ShortestPathModel theModel;
	
	GenerateListener(ShortestPathView v, ShortestPathModel m)
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
			input = theModel.GenerateObstacles();
			theView.pData.setText(input);		
			Problem problem = ShortestPathModel.parseData(input);
			ModelOut mo = ShortestPathModel.encodeData(problem.world, problem.start, problem.finish, problem.rows, problem.columns);
			theView.pMaze.setOutput(mo);	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	}

}
