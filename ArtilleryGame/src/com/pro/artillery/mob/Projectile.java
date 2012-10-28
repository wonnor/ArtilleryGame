package com.pro.artillery.mob;


public class Projectile extends Mob
{
	
	double xVel = 0;
	double yVel = 0;
	
    public Projectile()
    {
    	super();
    }

    public Projectile(double x, double y, double initXVel, double initYVel)
    {
    	super(x, y, "res/mob/projectile.png");
    	xVel = initXVel;
    	yVel = initYVel;
    }

	public void update(double gravity)
	{
		x += xVel;
		y += yVel;
		yVel += gravity;
	}

}