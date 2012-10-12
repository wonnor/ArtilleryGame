package com.pro.artillery.gui;

import java.awt.Graphics;

public abstract class MenuItem //extended by objects on the menu
{
	protected int x, y;
	protected float r, gr, b;
	
	public void setRGB(float r, float gr, float b) //set the RGB values
	{
		this.r = r;
		this.gr = gr;
		this.b = b;
	}
	
	public void update()
	{
		
	}
	
	public void draw(Graphics g)
	{
		
	}
}
