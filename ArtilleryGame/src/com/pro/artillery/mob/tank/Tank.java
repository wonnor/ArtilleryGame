package com.pro.artillery.mob.tank;

import com.pro.artillery.mob.*;

public class Tank extends Mob
{
	Projectile projectile;

    public Tank()
    {
    	super();
    }

    public Tank(double x, double y)
    {
    	super(x, y, "tank/tank.png");
    }

	/**
	 * Spawns a new projectile (eventually will spawn projectile at loc of tank "muzzle"
	 */
	public void fire()
	{
		projectile = new Projectile();
	}
}