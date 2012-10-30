package com.pro.artillery;

import com.pro.artillery.mob.Projectile;
import com.pro.artillery.state.KED;
import com.pro.artillery.state.Key;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * for testing the world
 * 
 * @author Mike
 * 
 */
public class Panel extends JPanel implements Runnable {
	World world;
	boolean running;

	public Panel() {
		world = new World(800, 600);
		running = true;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		world.draw(g);
	}

	public void run() {
		while (running) {
			world.update();
			repaint();
			java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KED());
			try {
				Thread.sleep(20);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}
	}
}
