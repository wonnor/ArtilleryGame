package com.pro.artillery.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Menu //the menu superclass. All menus extend this
{
	protected ArrayList<MenuItem> menuitems = new ArrayList<MenuItem>();
	protected Image menuimg;
	
	public void addItem(MenuItem item)
	{
		menuitems.add(item);
	}
	
	public void update()
	{
		for(MenuItem item : menuitems)
			item.update();
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(menuimg, 0, 0, null);
		for(MenuItem item : menuitems)
			item.draw(g);
	}
}
