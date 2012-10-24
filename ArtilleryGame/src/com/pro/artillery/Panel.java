package com.pro.artillery;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * for testing the world
 * @author Mike
 *
 */
public class Panel extends JPanel implements Runnable{
	World world;
	
	public Panel(){
		world = new World(800,600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		world.draw(g);
	}
	
	public void run(){
		repaint();
		
		try{
			Thread.sleep(20);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
