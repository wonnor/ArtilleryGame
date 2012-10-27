package com.pro.artillery;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.pro.artillery.gui.MainMenu;
import com.pro.artillery.gui.StartMenu;
import com.pro.artillery.state.StateMachine;

public class Game extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	private Thread game = new Thread(this); //Creates the thread
	private boolean isRunning = false; //the main running boolean
	
	//width and height of the game
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	//Allows you to alter the states
	private StateMachine.State startmenustate = StateMachine.State.START_MENU;
	private StateMachine.State mainmenustate = StateMachine.State.MAIN_MENU;
	public static StateMachine.State curstate = StateMachine.getCurrentState();
	
	//Menus
	public static StartMenu startMenu = new StartMenu();
	public static MainMenu mainMenu = new MainMenu();
	
	//Mouse Point
	public static Point mpoint = new Point(0, 0);
	
	public Game()
	{
		game.start();
	}
	
	public void run()
	{
		isRunning = true;
		//opens the startmenu
		StateMachine.openMenu(startmenustate);
		gameLoop();
	}
	
	//Main gameloop
	private void gameLoop()
	{
		while(isRunning)
		{
			//updates the menu effects
			updateMenus();
			//repaints the screen, resets the value of curstate,and sleeps the game for 20 milliseconds
			curstate = StateMachine.getCurrentState();
			repaint();
			try
			{
				game.sleep(20);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	private void updateMenus()
	{
		startMenu.update();
		mainMenu.update();
	}
	
	//Rendering. Probably should be replaced in the future
	public void paintComponent(Graphics g)
	{
		//draw based on state
		if(curstate == startmenustate)
		{
			startMenu.draw(g);
		}
		else if(curstate == mainmenustate)
		{
			mainMenu.draw(g);
		}
	}
}
