package com.pro.artillery.mob;

import java.awt.*;

// For working with images
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class Mob
{

	BufferedImage sprite;
	String imagePath = "mob.png";
	int x;
	int y;

    public Mob()
    {
    	setImage();
    }

    public Mob(int x, int y)
    {
    	setImage();
    	this.x = x;
    	this.y = y;
    }

	/**
	 * Increments the x-value (coord) of the mob by
	 * @param distance
	 */
	public void moveHorizontally(int distance)
	{
		x += distance;
	}

	/**
	 * Increments the y-value (coord) of the mob by
	 * @param distance
	 */
	public void moveVertically(int distance)
	{
		y += distance;
	}

    /**
     * Sets the image of this mob to the image located at field imagePath
     *
     */
    public void setImage()
    {
    	try
		{
    		sprite = ImageIO.read(new File(imagePath));
		}
		catch (IOException e) {System.out.println("Could not find " + imagePath);}
    }

	/**
	 * Flips the image of this mob
	 */
	public void flipImage()
	{
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-sprite.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		sprite = op.filter(sprite, null);
	}

	/**
	 * Returns bounding box of this image for purposes of rudimentary collision detection.
	 * @returns rectangle of same location and size as image.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
	}

	/**
	 * Draws image
	 * @param Graphics object g
	 */
	public void draw(Graphics g)
	{
		g.drawImage(sprite, x, y, null);
	}
}