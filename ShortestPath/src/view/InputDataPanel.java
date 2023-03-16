package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial") 
public class InputDataPanel extends JPanel
{	
	final int ROWS = 39;
	final int COLUMNS = 45;
	private JTextArea textArea = new JTextArea(ROWS,COLUMNS);
	
	InputDataPanel()
	{
		 textArea.setText("10 10\n"
		 		+ "\r\n"
		 		+ "2 2\r\n"
		 		+ "3 10\r\n"		 		
		 		+ "\r\n"
		 		+ "1 3\r\n"
		 		+ "2 3   2 6   2 7   2 8   2 9\r\n"
		 		+ "3 2   3 3   3 4   3 5   3 6\r\n"
		 		+ "4 5   4 9\r\n"
		 		+ "5 3   5 4   5 5   5 6   5 8   5 9   5 10\r\n"
		 		+ "6 3   6 10\r\n"
		 		+ "7 2   7 3   7 4   7 5   7 6   7 7  7 8\r\n"
		 		+ "8 5   8 9\r\n"
		 		+ "9 2   9 3   9 5   9 7   9 9\r\n"
		 		+ "10 2   10 7\r\n");
		 
		 this.setBackground(ShortestPathView.BACKGROUND_COLOR);
		 
		 this.add(new JLabel ("INPUT "));
		 this.add(new JScrollPane(textArea));
	}
	
	public void setText(String input)
	{
		textArea.setText(input);
		this.repaint();
	}
	
	public String getData()
	{
		return textArea.getText();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(500,700);
	}
}