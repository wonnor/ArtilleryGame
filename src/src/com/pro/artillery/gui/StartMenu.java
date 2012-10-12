package com.pro.artillery.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.pro.artillery.Game;

public class StartMenu extends Menu // the start menu
{
	private String title = "Artillery Game"; 
	private String start = "Press any button to start";
	private MenuString titleText; //contains the title
	private MenuString startText; // contains the start message
	private Image startmenuImg; //the image associated with the start menu
	
	public StartMenu()
	{
		define(); //defines the MenuStrings and the image
		add(); //add the strings to the menu
	}
	
	private void define()
	{
		titleText = new MenuString(title, (Game.WIDTH / 2) - 192, (Game.HEIGHT / 2) - 128, 1, 1, 1, "Times New Roman", 2, 64, false, false);
		startText = new MenuString(start, (Game.WIDTH / 2) - 128, (Game.HEIGHT / 2) + 192, 1, 1, 1, "Times New Roman", 0, 24, true, false);
		startmenuImg = new ImageIcon("res/placestart.png").getImage();
		menuimg = startmenuImg;
	}
	
	private void add()
	{
		addItem(titleText);
		addItem(startText);
	}
}
