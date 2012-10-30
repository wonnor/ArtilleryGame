package com.pro.artillery;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Vector;

import com.pro.artillery.mob.Projectile;
import com.pro.artillery.mob.tank.Tank;
import com.pro.artillery.state.Key;
import com.pro.artillery.state.StateMachine;


public class World {

	private int windSpeed = 0; //speed of wind which will equate to drag
	private double gravity = .1; //acceleration due to gravity for adjusting projectiles
	private int height, width; //dimensions of screen and world
	private Color sky, ground; // color variables for drawing the world
	public Vector<Projectile> projectiles;
	public Tank tank1;
	public Tank tank2;
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
		projectiles = new Vector<Projectile>();
		tank1 = new Tank(20, land.height-32, Tank.Color.BLUE);
		tank2 = new Tank(716, land.height-32, Tank.Color.RED);
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
	public double getGravity(){
		return gravity;
	}

	public void update(){
		if (StateMachine.getCurrentState() == StateMachine.State.PLAYER_ONE_TURN)
			tank1.update(projectiles);
		else if (StateMachine.getCurrentState() == StateMachine.State.PLAYER_TWO_TURN)
			tank2.update(projectiles);
		Iterator<Projectile> itr = projectiles.iterator();
		while (itr.hasNext()) {
			Projectile p = itr.next();
			p.update(gravity);
			if (p.getBoundingBox().intersects(new Rectangle(land.corner.x, land.corner.y, land.width, land.height))) {
				itr.remove();
			}
			else if (p.isCollidingWith(tank1)) {
				itr.remove();
				System.out.println("Player 1 hit!");
			}
			else if (p.isCollidingWith(tank2)) {
				itr.remove();
				System.out.println("Player 2 hit!");
			}
			else if (p.getBoundingBox().getMinX() < 0  || p.getBoundingBox().getMaxX() > width) {
				itr.remove();
			}
		}
	}

	/**
	 * Draws the world
	 * Draws the terrain
	 */
	public void draw(Graphics g){
		g.setColor(sky);
		g.fillRect(0,0,width,height);
		land.draw(g);
		for (Projectile p : projectiles) {
			p.draw(g);
		}
		tank1.draw(g);
		tank2.draw(g);
	}
}
/**
 * Mike K
 */
