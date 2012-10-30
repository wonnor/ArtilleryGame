package com.pro.artillery.mob.tank;

import java.awt.Graphics;

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
    
    public void update() {
    	if (Key.pressedD)
    		muzzle.rotate(.01);
    	else if (Key.pressedA)
    		muzzle.rotate(-.01);
    }
    
	/**
	 * Spawns a new projectile (eventually will spawn projectile at loc of tank "muzzle"
	 */
}