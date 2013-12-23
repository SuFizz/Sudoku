/*
 * File: sudokuCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the
 * sudoku are displayed.  NOTE: This class updates the display
 * when the window is resized.
 */


import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.applet.*;



public class sudokuCanvas extends GCanvas 
	implements sudokuConstants, ComponentListener {

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public sudokuCanvas(){
		update();
		addComponentListener(this);
		numbers_begin = new int[9][9];
		numbers_added = new int[9][9];
		
//		addMouseListeners();
	}
	public void clear() {}
	
	public void update(){
		removeAll();

		double spacingX = getWidth()/BOARD_SIZE;
		double spacingY = getHeight()/BOARD_SIZE;
		double kuttispace = 2.5;
		for(int i=0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j)
				add(new GRect(i*spacingX, j*spacingY, spacingX - kuttispace, spacingY - kuttispace));
				
/*		for(int i=0; i<BOARD_SIZE; ++i){
			add(new GRect(i*spacingX, 0, i*spacingX, getHeight()));
			add(new GLine(0,i*spacingY,getWidth(),i*spacingY));}*/

		GLine lineX1 = new GLine(getWidth()/BOX_SIZE, 0, getWidth()/BOX_SIZE, getHeight());
		lineX1.setColor(Color.RED);
		add(lineX1);
		
		GLine lineX2 = new GLine(2*getWidth()/BOX_SIZE, 0, 2*getWidth()/BOX_SIZE, getHeight());
		lineX2.setColor(Color.RED);
		add(lineX2);
		
		GLine lineY1 = new GLine(0, getHeight()/BOX_SIZE, getWidth(), getHeight()/BOX_SIZE);
		lineY1.setColor(Color.RED);
		add(lineY1);
		
		GLine lineY2 = new GLine(0, 2*getHeight()/BOX_SIZE, getWidth(), 2*getHeight()/BOX_SIZE);
		lineY2.setColor(Color.RED);
		add(lineY2);
		}
		
	public void initArray(int[][] numbers,Color color)
	{	
		double spacingX = getWidth()/BOARD_SIZE;
		double spacingY = getHeight()/BOARD_SIZE;
		double kuttispace = 2.5;

		for(int i =0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j)
			{	numbers_begin[j][i] = numbers[j][i];
				if(numbers[j][i] >= 1)
					{GLabel num_lab = new GLabel(""+numbers[j][i]);
					num_lab.setColor(color);
					add(num_lab,(0.5+i)*spacingX, (0.5+j)*spacingY);}}
	}
	
	public void ArrayColorer(int[][] numbers,Color color)
	{	
		double spacingX = getWidth()/BOARD_SIZE;
		double spacingY = getHeight()/BOARD_SIZE;
		double kuttispace = 2.5;

		for(int i =0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j)
			{	numbers_added[j][i] = numbers[j][i];
				if(numbers[j][i] >=1 && numbers_begin[j][i] <=0)
					{GLabel num_lab = new GLabel(""+numbers[j][i]);
					num_lab.setColor(color);
//					remove(getElementAt((0.5+i)*spacingX, (0.5+j)*spacingY));
					add(num_lab,(0.5+i)*spacingX, (0.5+j)*spacingY);}
				if(numbers[j][i] == -1 && numbers_begin[j][i] <=0)
					{GLabel num_lab = new GLabel(""+numbers[j][i]);
					num_lab.setColor(color);
//					remove(getElementAt((0.5+i)*spacingX, (0.5+j)*spacingY));
					add(num_lab,(0.5+i)*spacingX, (0.5+j)*spacingY);}
					
			}
	}
	
	public void putBig(int Y, int X)
	{
		double spacingX = getWidth()/BOARD_SIZE;
		double spacingY = getHeight()/BOARD_SIZE;
		double kuttispace = 2.5;
		GRect ht = new GRect((X-1)*spacingX, (Y-1)*spacingY, spacingX - kuttispace, spacingY - kuttispace);
		ht.setFilled(true);
		ht.setFillColor(Color.CYAN);
		add(ht);
//		ht.

//		ArrayColorer(numbers_added,Color.RED);
//		initArray(numbers_begin,Color.BLUE);
	}

	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update();	ArrayColorer(numbers_added,Color.RED);	initArray(numbers_begin,Color.BLUE); }
	public void componentShown(ComponentEvent e) { }
	private int[][] numbers_begin;
	private int[][] numbers_added;

	/**	Color for already existing*/
//	public static final Color EXIST_COLOR = Color.BLUE;

	/**	Color for new added*/
//	public static final Color ADDED_COLOR = Color.RED;
	
}
