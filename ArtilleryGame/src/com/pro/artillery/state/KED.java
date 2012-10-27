package com.pro.artillery.state;

import java.awt.*;

public class KED implements KeyEventDispatcher
{

    public boolean dispatchKeyEvent(java.awt.event.KeyEvent event)
	{
		String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
		if (key.equals("pressed A"))
			Key.pressedA = true;
		else if (key.equals("released A"))
			Key.pressedA = false;
		if (key.equals("pressed D"))
			Key.pressedD = true;
		else if (key.equals("released D"))
			Key.pressedD = false;
		if (key.equals("pressed W"))
			Key.pressedW = true;
		else if (key.equals("released W"))
			Key.pressedW = false;
		if (key.equals("pressed S"))
			Key.pressedA = true;
		else if (key.equals("released S"))
			Key.pressedS = false;
		if (key.equals("pressed SPACE"))
			Key.pressedSPACE = true;
		else if (key.equals("released SPACE"))
			Key.pressedSPACE = false;
		System.out.println(key);
		return true;
	}
    
}