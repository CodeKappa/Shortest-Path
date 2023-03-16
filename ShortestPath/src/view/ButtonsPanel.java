package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonsPanel extends JPanel
{
	private JButton SubmitButton = new JButton("Submit");
	private JButton SearchButton = new JButton("Search");
	private JButton GenerateButton = new JButton("Generate");
	private JButton MovementTypeButton = new JButton("Horse Movement");
	
	ButtonsPanel()
	{	
		this.add(SubmitButton);
		this.add(SearchButton);	
		this.add(GenerateButton);
		this.add(MovementTypeButton);
		this.setBackground(Color.WHITE);
	}
	
	public String swapMovementText()
	{
		if(MovementTypeButton.getText() == "Horse Movement")
			MovementTypeButton.setText("Normal Movement");
		else 
			MovementTypeButton.setText("Horse Movement");
	
		this.repaint();
		
		return MovementTypeButton.getText();
	}
	
	public void addSearchListener(ActionListener listenForSearchButton)
	{
		SearchButton.addActionListener(listenForSearchButton);
	}
	
	public void addSubmitListener(ActionListener listenForSubmitButton)
	{
		SubmitButton.addActionListener(listenForSubmitButton);
	}
	
	public void addGenerateListener(ActionListener listenForGenerateButton)
	{
		GenerateButton.addActionListener(listenForGenerateButton);
	}
	
	public void addMovementTypeListener(ActionListener listenForMovementTypeButton)
	{
		MovementTypeButton.addActionListener(listenForMovementTypeButton);
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(450,35);
	}
}