package com.pro.artillery;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Terrain {
	
	int width, height;
	Point corner = new Point(0,0);
	Color hue;
	
	public Terrain(int w, int h, int x, int y,Color color){
		width = w;
		height = h;
		corner.x = x;
		corner.y = y;
		hue = color;
	}
	
	public void draw(Graphics g){
		g.setColor(hue);
		g.fillRect(corner.x, corner.y, width, height);
	}
	
}
/**
 * Mike K
 */