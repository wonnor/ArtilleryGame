package com.pro.artillery.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import com.pro.artillery.Game;
import com.pro.artillery.state.StateMachine;

public class Frame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(800, 600); //Dimension of the Frame
	
	public Frame()
	{
		init();
	}
	
	private void init() //Initialize the Frame
	{
		setVisible(true);
		Game game = new Game();
		add(game);
		pack();
		setSize(size);
		game.setSize(Game.WIDTH, Game.HEIGHT);
		setTitle("Artillery Game V0.007");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Temporary Input system, for testing purposes
		requestFocus();
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent ke)
			{
				if(Game.curstate == StateMachine.State.START_MENU)
					StateMachine.openMenu(StateMachine.State.MAIN_MENU);
			}
			
			public void keyReleased(KeyEvent ke)
			{
				
			}
			
			public void keyTyped(KeyEvent ke)
			{
				
			}
		});
		addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent me)
			{
				
			}

			@Override
			public void mouseMoved(MouseEvent me) 
			{
				Game.mpoint = new Point(me.getX() , me.getY() - 25);
			}
		});
		
	}
}
