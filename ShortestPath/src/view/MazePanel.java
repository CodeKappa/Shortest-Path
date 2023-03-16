package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;

import model_bll.ModelOut;
import model_bll.TileType;

@SuppressWarnings("serial")
public class MazePanel extends JPanel
{
	private TileType [][] matrix;
	private int matrixRows;
	private int matrixColumns;
	private int squareSize;
	private int gap;
	Map <TileType, Color> colors;
	
	MazePanel() 
	{
		super();
		
		colors = new TreeMap <TileType, Color> ();
		colors.put(TileType.OBSTACLE, new Color(0, 0, 0));
		colors.put(TileType.EMPTY, new Color(255, 255, 255));
		colors.put(TileType.START, new Color(255, 0, 0));
		colors.put(TileType.FINISH, new Color(0, 0, 255));
		colors.put(TileType.PATH, new Color(255, 255, 0));
			
		setBackground(ShortestPathView.BACKGROUND_COLOR);
	}

	public void setOutput(ModelOut m)
	{
		this.matrix = m.matrix;
		this.matrixRows = m.matrixRows;
		this.matrixColumns = m.matrixColumns;
		this.gap = m.gap;
		this.squareSize = m.squareSize;
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
				
		for(int i = 1; i <= this.matrixRows; i++)
		{
			for(int j = 1; j <= this.matrixColumns; j++)
			{
				g2d.setColor(colors.get(matrix[i][j]));
				g2d.fillRect((j-1) * (squareSize + gap), (i-1) * (squareSize + gap), squareSize, squareSize);
			}
		}
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(700,700);
	}
}