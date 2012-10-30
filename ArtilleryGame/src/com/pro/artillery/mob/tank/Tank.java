package com.pro.artillery.mob.tank;

import java.awt.Graphics;
import java.util.Vector;

import com.pro.artillery.mob.*;
import com.pro.artillery.state.Key;
import com.pro.artillery.state.StateMachine;

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
    	double cos_theta = Math.cos(theta);
    	double sin_theta = Math.sin(theta);
    	projectiles.add(new Projectile((muzzle.getBoundingBox().x)+cos_theta*28+sin_theta, (muzzle.getBoundingBox().y+32)+sin_theta*32-Math.abs(cos_theta*5),cos_theta*8, sin_theta*8));
    	StateMachine.advanceTurn();
    }
}