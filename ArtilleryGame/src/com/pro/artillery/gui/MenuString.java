package com.pro.artillery.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.pro.artillery.Game;

public class MenuString extends MenuItem //Text on the menu
{
	private String text; //text of the string
	private int fontstyle; // the fontstyle. Bold, italcs, etc
	private int fontsize; //size of the text
	private String font; //the font used
	boolean isFlashing = false; //whether the text is flashing
	private float a = 1.0f; //the alpha value; 1 by default
	private boolean increment = false; //increment the transparency when flashing
	private boolean decrement = true; //decrement the transparency when flashing; since a is 1 by default, decrement is true by default
	private boolean hasBox = false;//whether it needs a bounding box, for when a string can act as a button
	private Rectangle boundingBox = new Rectangle(0, 0, 0, 0); //the bounding box itself, initialized to 0 to avoid nullpointers
	
	public MenuString(String text, int x, int y, float r, float gr, float b, String font, int fontstyle, int fontsize, boolean flashing, boolean highlight)
	{
		this.x = x;
		this.y = y;
		this.text = text;
		this.font = font;
		this.fontsize = fontsize;
		
		//fontstyle must 0, 1, or 2
		//0 is plain
		//1 is bold
		//2 is italics
		//anything else is automatically plain
		if(fontstyle == 0)
			this.fontstyle = Font.PLAIN;
		else if(fontstyle == 1)
			this.fontstyle = Font.BOLD;
		else if(fontstyle == 2)
			this.fontstyle = Font.ITALIC;
		else
			fontstyle = Font.PLAIN;
		
		isFlashing = flashing;
		hasBox = highlight;
		
		//set the rgb of the text
		setRGB(r, gr, b);
	}
	
	public void defineBox(int x, int y, int width, int height)
	{
		//sets the box to the parameters of defineBox()
		boundingBox.setBounds(x, y, width, height);
	}
	
	public void update()
	{
		//if it has a box, then it can flash when the mouse is inside it
		if(hasBox)
		{
			if(boundingBox.contains(Game.mpoint))
				isFlashing = true;
			else
				isFlashing = false;
		}
		
		//controls the flashing
		if(isFlashing)
		{
			if(increment && a < .9f)
			{
				a += 0.03f;
				if(a >= .9f)
				{
					increment = false;
					decrement = true;
				}
			}	
			else if(decrement && a > .1f)
			{
				a -= 0.03f;
				if(a <= .1f)
				{
					increment = true;
					decrement = false;
				}
			}
		}
	}
	
	public void draw(Graphics g)
	{
		//controls the drawing
		g.setFont(new Font(font, fontstyle, fontsize));
		//if it flashes, draw with an alpha value
		if(isFlashing)
			g.setColor(new Color(r, gr, b, a));
		else
			g.setColor(new Color(r, gr, b));
		g.drawString(text, x, y);
	}
}
