package com.pro.artillery;
import java.awt.Color;
import java.awt.Graphics;


public class World {
	
	private int windSpeed = 0; //speed of wind which will equate to drag
	private int gravity = 10; //acceleration due to gravity for adjusting projectiles
	private int height, width; //dimensions of screen and world
	private Color sky, ground; // color variables for drawing the world
	public Terrain land;
	
	
	/**
	 * generates the world and terrain
	 */
	public World(int w,int h){
		width = w;
		height = h;
		define();
	}
	
	/**
	 * defines colors and will be used for any other extraneous calculations
	 * but colors can always be imported
	 */
	public void define(){
		sky = new Color(199,255,235);
		ground = new Color(39,165,28);
		land = new Terrain(width,height/2,0,height/2,ground);
	}
	
	/**
	 * Beginning of the return methods
	 * @return the wind speed for adjusting projectiles
	 */
	public int getWindSpeed(){
		return windSpeed;
	}
	
	/**
	 * @return the gravity for adjusting projectiles
	 */
	public int getGravity(){
		return gravity;
	}
	
	/**
	 * Draws the world
	 * Draws the terrain
	 */
	public void draw(Graphics g){
		g.setColor(sky);
		g.fillRect(0,0,width,height);
		land.draw(g);
	}
}
/**
 * Mike K
 */
