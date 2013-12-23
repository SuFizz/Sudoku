/* 
 * File: sudoku.java
 * -----------------------
 * When it is finished, this program will implement a basic sudoku puzzle
 */
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public void sudoku implements sudokuConstants extends sudokuCanvas{

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init()
	{
		game = new sudokuProfile();
		gameInProgress = new String();

		add(new JButton("NEW GAME"), SOUTH);

		add(new JLabel("File Name : "), SOUTH);

		nameField = new JTextField(TEXT_FIELD_SIZE);
		add(nameField,NORTH);

		add(new JButton("LOAD GAME"), SOUTH);

		addActionListeners();
		nameField.addActionListener(this);
	}
	
	/**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e)
    {
	    String but_pressed = e.getActionCommand();
		String nameF = nameField.getText();
		if(e.getSource() == nameField || but_pressed.equals("LOAD GAME"))
			{game.load(nameF);
			gameInProgress = nameF;
			}
		else
			
    }
	

	private JTextField nameField;
	private GLabel choose;
	private GButton NewGame;
	private GButton LoadGame;
	private sudokuProfile game;
	private String gameInProgress;	
}
