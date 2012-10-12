package com.pro.artillery.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.pro.artillery.Game;

public class MainMenu extends Menu //main menu
{
	//the text in the menu strings
	private String title = "Artillery Game";
	private String single = "Singleplayer";
	private String split = "Multiplayer- Same Computer";
	private String lan = "Multiplayer- LAN";
	private String online = "Multiplayer- Online";
	private String credits = "Credits";
	
	//contains the text
	private MenuString titleText;
	private MenuString singleText;
	private MenuString splitText;
	private MenuString lanText;
	private MenuString onlineText;
	private MenuString creditsText;
	private Image startmenuImg;
	
	public MainMenu()
	{
		define(); //define the MenuStrings and images
		box();//set the bounding box
		add();//add to the menu
	}
	
	private void define()
	{
		titleText = new MenuString(title, (Game.WIDTH / 2) - 300, (Game.HEIGHT / 2) - 160, 1, 1, 1, "Times New Roman", 2, 64, false, false);
		singleText = new MenuString(single, 500, (Game.HEIGHT/ 2) - 60, 1, 1, 1, "Times New Roman", 0, 24, false, true);
		splitText = new MenuString(split, 500, (Game.HEIGHT / 2) , 1, 1, 1, "Times New Roman", 0, 24, false, true);
		lanText = new MenuString(lan, 500, (Game.HEIGHT / 2) + 60, 1, 1, 1, "Times New Roman", 0, 24, false, true);
		onlineText = new MenuString(online, 500, (Game.HEIGHT / 2) + 120, 1, 1, 1, "Times New Roman", 0, 24, false, true);
		creditsText = new MenuString(credits, 500, (Game.HEIGHT / 2) + 180, 1, 1, 1, "Times New Roman", 0, 24, false, true);
		
		startmenuImg = new ImageIcon("res/placemain.png").getImage();
		menuimg = startmenuImg;
	}
	
	private void box()
	{
		singleText.defineBox(singleText.x - 1, singleText.y - 20, 288, 24);
		splitText.defineBox(splitText.x - 1, splitText.y -20, 288, 24);
		lanText.defineBox(lanText.x - 1, lanText.y - 20, 288, 24);
		onlineText.defineBox(onlineText.x - 1, onlineText.y - 20, 288, 24);
		creditsText.defineBox(creditsText.x - 1, creditsText.y - 20, 288, 24);
	}
	
	private void add()
	{
		addItem(titleText);
		addItem(singleText);
		addItem(splitText);
		addItem(lanText);
		addItem(onlineText);
		addItem(creditsText);
	}
}

