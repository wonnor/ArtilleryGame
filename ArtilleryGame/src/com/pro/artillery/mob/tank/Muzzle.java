package com.pro.artillery.mob.tank;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import com.pro.artillery.mob.*;

public class Muzzle extends Mob
{
	double rotation = 0; //IN RADIANS
	
    public Muzzle()
    {
    	super();
    }

    public Muzzle(double x, double y, Tank.Color color)
    {
    	super(x, y, "res/mob/tank/muzzle_blue.png");
    	if (color == Tank.Color.RED)
    		setImage("res/mob/tank/muzzle_red.png");
    }
    
    public void draw(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D) g;
    	AffineTransform xform = new AffineTransform();
    	xform.translate(0.5*getBoundingBox().width, getBoundingBox().height);
    	xform.rotate(rotation);
    	xform.translate(-0.5*getBoundingBox().width, -getBoundingBox().height);
    	g2d.drawImage(sprite, new AffineTransformOp(xform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR), (int)x, (int)y);
    }
    
    public void rotate(double theta)
    {
    	if (rotation < Math.PI/2 && theta>0)
    		rotation += theta;
    	else if (rotation > -Math.PI/2 && theta<0)
    		rotation += theta;
    }
    
}