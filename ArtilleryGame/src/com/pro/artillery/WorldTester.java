package com.pro.artillery;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pro.artillery.state.StateMachine;
/**
 * for testing the world before the menu is finished
 * @author Mike
 *
 */
public class WorldTester{
	static JFrame frame;
	static Panel panel;
	public static void main(String[] args){
		frame = new JFrame();
		frame.setSize(800,600);
		panel = new Panel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StateMachine.setCurrentState(StateMachine.State.PLAYER_ONE_TURN);
	}
	public void run(){
		
	}
}
