package com.pro.artillery.mob.tank;

import java.awt.Graphics;
import java.util.Vector;

import com.pro.artillery.mob.*;
import com.pro.artillery.state.Key;

public class Tank extends Mob
{

	Muzzle muzzle;
	
    public Tank()
    {
    	super();
    	muzzle = new Muzzle(getBoundingBox().x+40, getBoundingBox().y-32);
    }

    public Tank(double x, double y)
    {
    	super(x, y, "res/mob/tank/tank.png");
    	muzzle = new Muzzle(getBoundingBox().x+40, getBoundingBox().y-32);
    }

    public void draw(Graphics g)
    {
    	super.draw(g);
    	muzzle.draw(g);
    }
    
    public void update(Vector<Projectile> projectiles) {
    	if (Key.pressedD)
    		muzzle.rotate(.01);
    	else if (Key.pressedA)
    		muzzle.rotate(-.01);
		if (Key.pressedSPACE && projectiles.isEmpty())
	    	fire(projectiles);
    }
    
	/**
	 * Spawns a new projectile (eventually will spawn projectile at loc of tank "muzzle"
	 */
    public void fire(Vector<Projectile> projectiles) {
    	double theta = muzzle.rotation-Math.PI/2;
    	projectiles.add(new Projectile((muzzle.getBoundingBox().x)+Math.cos(theta)*32, (muzzle.getBoundingBox().y+32)+Math.sin(theta)*32,0,0));// Math.cos(theta)*8, Math.sin(theta)*8));
    }
}