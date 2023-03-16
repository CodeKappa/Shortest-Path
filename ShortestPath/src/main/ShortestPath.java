package main;

import controller.ShortestPathController;
import model_bll.ShortestPathModel;
import view.ShortestPathView;

public class ShortestPath
{

	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				ShortestPathView theView = new ShortestPathView();				
				ShortestPathModel theModel = new ShortestPathModel();
				@SuppressWarnings("unused")
				ShortestPathController theController = new ShortestPathController(theView, theModel);
				theView.setVisible(true); 
			} 
		});
	}
}