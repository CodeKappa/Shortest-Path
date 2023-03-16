package controller;

import model_bll.ModelOut;
import model_bll.Problem;
import model_bll.ShortestPathModel;
import view.ShortestPathView;

public class ShortestPathController 
{
	protected ShortestPathView theView;
	protected ShortestPathModel theModel;
	
	public ShortestPathController(ShortestPathView theView, ShortestPathModel theModel) 
	{
		super();
		this.theView = theView;
		this.theModel = theModel;
		this.theView.pButtons.addSubmitListener(new SubmitListener(theView, theModel));
		this.theView.pButtons.addSearchListener(new SearchListener(theView, theModel));
		this.theView.pButtons.addGenerateListener(new GenerateListener(theView, theModel));
		this.theView.pButtons.addMovementTypeListener(new MovementTypeListener(theView, theModel));
		
		String input = theView.pData.getData();
		Problem problem = ShortestPathModel.parseData(input);
		ModelOut mo = ShortestPathModel.encodeData(problem.world, problem.start, problem.finish, problem.rows, problem.columns);
		theView.pMaze.setOutput(mo);	
		
	}	
}



