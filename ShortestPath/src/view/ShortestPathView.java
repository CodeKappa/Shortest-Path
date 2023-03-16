package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ShortestPathView extends JFrame
{
	public InputDataPanel pData = new InputDataPanel();
	public ButtonsPanel pButtons = new ButtonsPanel();
	public MazePanel pMaze = new MazePanel();
	
	static final Color BACKGROUND_COLOR = new Color(255, 150, 43);
	
	public ShortestPathView()
	{			
		this.setTitle("Shortest Path");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel viewPanel = makePanel();
		
		this.setResizable(false);
		this.add(viewPanel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	private JPanel makePanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(BACKGROUND_COLOR, 3));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel pTop = new LegendPanel();
		JPanel pBottom = new JPanel();
		
		this.pData.add(this.pButtons);
		pBottom.add(this.pData);
		pBottom.add(this.pMaze);
		
		panel.add(pTop);
		panel.add(pBottom);

		return panel;
	}

}
