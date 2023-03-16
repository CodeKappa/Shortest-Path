package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Panels extends JPanel
{
	public InputDataPanel pData;
	public ButtonsPanel pButoane;
	public MazePanel pMatrice;
	
	Panels()
	{
		JPanel pTop = new LegendPanel();
		JPanel pBottom = new JPanel();
		
		this.pData = new InputDataPanel();
		this.pButoane = new ButtonsPanel();

		this.pData.add(this.pButoane);
		this.pMatrice = new MazePanel();		
		
		pBottom.add(this.pData);
		pBottom.add(this.pMatrice);
	
		add(pTop);
		add(pBottom);
		setBorder(new LineBorder(Color.RED, 3));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}