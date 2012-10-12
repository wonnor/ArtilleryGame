package com.pro.artillery.mob;

public class Tank extends Mob
{

	String imagePath = "tank/tank.png";
	String muzzlePath = "tank/muzzle.png";
	Projectile projectile;

    public Tank()
    {
    	super();
    }

    public Tank(int x, int y)
    {
    	super(x, y);
    }

	/**
	 * Spawns a new projectile (eventually will spawn projectile at loc of tank "muzzle"
	 */
	public void fire()
	{
		projectile = new Projectile();
	}
}